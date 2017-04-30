package bivachi.agustin.calculator.model;

/**
 * Created by agustinbivachi on 27/4/17.
 */
public class Equals extends Operation {

  @Override
  public Double calculate(Double firstOperand, Double accumulator) {
    return accumulator;
  }

}
