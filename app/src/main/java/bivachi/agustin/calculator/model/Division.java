package bivachi.agustin.calculator.model;

/**
 * Created by agustinbivachi on 27/4/17.
 */
public class Division extends Operation {

  @Override
  public Double calculate(Double firstOperand, Double accumulator) {
    if (accumulator == 0.0){
      return null;
    }else {
      return firstOperand / accumulator;
    }
  }

}
