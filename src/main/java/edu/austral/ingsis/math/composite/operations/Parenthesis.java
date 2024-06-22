package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

public class Parenthesis extends SingleVariableOperation{

  public Parenthesis(Function function) {
    super(function);
  }

  @Override
  public double evaluate() {
    return getFunction().evaluate();
  }

  @Override
  public String print() {
    return "(" + getFunction().print() + ")";
  }
}
