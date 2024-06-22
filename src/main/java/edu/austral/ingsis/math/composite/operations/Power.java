package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

public class Power extends TwoVariableOperation {

  public Power(Function function1, Function function2) {
    super(function1, function2);
  }

  @Override
  public double evaluate() {
    return Math.pow(getFunction1().evaluate(), getFunction2().evaluate());
  }

  @Override
  public String print() {
    return getFunction1().print() + " ^ " + getFunction2().print();
  }
}
