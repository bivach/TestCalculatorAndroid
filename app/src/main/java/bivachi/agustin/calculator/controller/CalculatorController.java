package bivachi.agustin.calculator.controller;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import bivachi.agustin.calculator.model.PendingBinaryOperation;

/**
 * Created by agustinbivachi on 26/4/17.
 */
public class CalculatorController {

  private Double accumulator;
  private PendingBinaryOperation pendingOperation;

  public CalculatorController() {
    this.accumulator = 0.0;
  }

  public void setAccumulator(String display) {
    this.accumulator = parseStringToNumber(display);
  }

  public String getResult(){
    if (accumulator!=null){
      return formatNumberToString(accumulator);
    }else {
      reset();
      return "Error";
    }
  }

  public void performOperation(String currentSymbol) {
      executePendingBinaryOperation();
      pendingOperation = new PendingBinaryOperation(accumulator,currentSymbol);
  }

  private void executePendingBinaryOperation() {
    if (pendingOperation != null) {
      accumulator = pendingOperation.getCurrentOperationToPerform().calculate(pendingOperation.getFirstOperand(), accumulator);
      pendingOperation = null;
    }
  }

  public void reset() {
    this.accumulator = 0.0;
    this.pendingOperation = null;
  }

  public String formatNumberToString(Double result) {
    NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
    DecimalFormat decimalFormat = (DecimalFormat)nf;
    return decimalFormat.format(result);
  }

  private Double parseStringToNumber(String display) {
    return Double.parseDouble(display.replace(".","").replace(",",".").replace("Error","0"));
    //replace methods are to handle parse errors
  }

}
