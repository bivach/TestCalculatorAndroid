package bivachi.agustin.calculator.controller;

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

  public Double getResult(){
    return accumulator;
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

}
