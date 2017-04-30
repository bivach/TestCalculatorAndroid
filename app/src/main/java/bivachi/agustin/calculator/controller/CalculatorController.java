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

  public void setAccumulator(Double accumulator) {
    this.accumulator = accumulator;
  }

  public String getResult(){
    if (accumulator!=null){
      return formatNumber(accumulator);
    }else {
      accumulator = 0.0;
      pendingOperation.setFirstOperand(0.0);
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

  public String formatNumber(Double result) {
    NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
    DecimalFormat decimalFormat = (DecimalFormat)nf;
    return decimalFormat.format(result);
  }

}
