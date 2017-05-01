package bivachi.agustin.calculator.model;

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
    operations.put("x",new Multiply());
    operations.put("+",new Addition());
    operations.put("-",new Subtraction());
    operations.put("÷",new Division());
    operations.put("=",new Equals());
  }

  public Double getFirstOperand() {
    return firstOperand;
  }

  public Operation getCurrentOperationToPerform() {
    return currentOperationToPerform;
  }

  public void setCurrentOperationToPerform(Operation currentOperationToPerform) {
    this.currentOperationToPerform = currentOperationToPerform;
  }

  public void setOperationValues(Double firstOperand, String currentSymbol){
    this.firstOperand = firstOperand;
    this.currentOperationToPerform = operations.get(currentSymbol);

  }
}
