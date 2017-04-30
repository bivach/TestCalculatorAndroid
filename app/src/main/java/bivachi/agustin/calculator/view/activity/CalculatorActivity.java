package bivachi.agustin.calculator.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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

  private Double getDisplayValue() {
    String display = displayTextView.getText().toString().replace(".", "").replace(",",".").replace("Error","0");
    /*  replace methods are for Double parse and to handle user error if types x/0  */
    return Double.parseDouble(display);
  }

  public void touchDigit(View v) {
    Button button = (Button) v;
    if(userIsInTheMiddleOfTyping && !displayTextView.getText().equals("0")) {
      displayTextView.setText(displayTextView.getText().toString() + button.getText());
    }else{
      displayTextView.setText(button.getText().toString());
    }
    userIsInTheMiddleOfTyping = true;
  }

  public void performOperation(View v) {

    Button button = (Button) v;
    String operatorSymbol = button.getText().toString();

    if (userIsInTheMiddleOfTyping || userPerformEquals){
      calculatorController.setAccumulator(getDisplayValue());
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
