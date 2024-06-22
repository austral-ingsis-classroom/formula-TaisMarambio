package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

public class Absolute extends SingleVariableOperation {

  public Absolute(Function function) {
    super(function);
  }

  @Override
  public double evaluate() {
    return Math.abs(getFunction().evaluate());
  }

  @Override
  public String print() {
    return "|" + getFunction().print() + "|";
  }
}
