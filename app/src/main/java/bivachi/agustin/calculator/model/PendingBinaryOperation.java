package bivachi.agustin.calculator.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by agustinbivachi on 30/4/17.
 */
public class PendingBinaryOperation {
  private Double firstOperand;
  private Operation currentOperationToPerform;
  private Map<String, Operation> operations;

  public PendingBinaryOperation(Double firstOperand,String currentSymbol) {
    this.firstOperand = firstOperand;
    this.operations = new HashMap<>();
    this.operations.put("x",new Multiply());
    this.operations.put("+",new Addition());
    this.operations.put("-",new Subtraction());
    this.operations.put("÷",new Division());
    this.operations.put("=",new Equals());
    this.currentOperationToPerform = operations.get(currentSymbol);
  }

  public Double getFirstOperand() {
    return firstOperand;
  }

  public Operation getCurrentOperationToPerform() {
    return currentOperationToPerform;
  }

}
