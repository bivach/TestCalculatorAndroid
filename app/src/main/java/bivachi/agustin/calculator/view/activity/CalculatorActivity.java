package bivachi.agustin.calculator.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import bivachi.agustin.calculator.R;
import bivachi.agustin.calculator.controller.CalculatorController;
import butterknife.ButterKnife;

public class CalculatorActivity extends AppCompatActivity {

  @BindView(R.id.displayTextView) TextView displayTextView;

  private Boolean userIsInTheMiddleOfTyping;
  private Boolean userPerformEquals;
  private CalculatorController calculatorController;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_calculator);
    ButterKnife.bind(this);
    calculatorController = new CalculatorController();
    userIsInTheMiddleOfTyping = false;
    userPerformEquals = false;
  }

  private String getDisplayTxt() {
    return displayTextView.getText().toString();
  }

  public void touchDigit(View v) {
    Button button = (Button) v;
    if(userIsInTheMiddleOfTyping && !getDisplayTxt().equals("0")) {
      displayTextView.setText(getDisplayTxt() + button.getText());
    }else{
      displayTextView.setText(button.getText().toString());
    }
    userIsInTheMiddleOfTyping = true;
  }

  public void performOperation(View v) {

    Button button = (Button) v;
    String operatorSymbol = button.getText().toString();

    if (userIsInTheMiddleOfTyping || userPerformEquals){
      calculatorController.setAccumulator(getDisplayTxt());
      calculatorController.performOperation(operatorSymbol);
      userIsInTheMiddleOfTyping = false;
    }

    userPerformEquals = operatorSymbol.equals("=");
    displayTextView.setText(calculatorController.getResult());

  }

  public void clearAll(View v) {
    displayTextView.setText("0");
    userIsInTheMiddleOfTyping = false;
    userPerformEquals = false;
    calculatorController.reset();
  }

}
