package bivachi.agustin.kotlintest.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by agustinbivachi on 30/4/17.
 */
public class PendingBinaryOperation {
  private Double firstOperand;
  private Operation currentOperationToPerform;
  Map<String, Operation> operations = new HashMap<>();

  public PendingBinaryOperation() {
    operations.put("x", Operation.MULTIPLY);
    operations.put("+", Operation.ADDITION);
    operations.put("-", Operation.SUBTRACTION);
    operations.put("÷", Operation.DIVISION);
    operations.put("=", Operation.EQUALS);
  }

  public Double getFirstOperand() {
    return firstOperand;
  }

  public Operation getCurrentOperationToPerform() {
    return currentOperationToPerform;
  }

  public void resetPendingBinaryOperation() {
    this.currentOperationToPerform = null;
    this.firstOperand = null;
  }

  public void setOperationValues(Double firstOperand, String currentSymbol){
    this.firstOperand = firstOperand;
    this.currentOperationToPerform = operations.get(currentSymbol);
  }

}
