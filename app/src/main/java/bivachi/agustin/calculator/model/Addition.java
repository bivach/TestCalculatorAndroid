package bivachi.agustin.calculator.model;

/**
 * Created by agustinbivachi on 27/4/17.
 */
public class Addition extends Operation {

  @Override
  public Double calculate(Double firstArgument, Double secondArgument) {
    return firstArgument + secondArgument;
  }

}
