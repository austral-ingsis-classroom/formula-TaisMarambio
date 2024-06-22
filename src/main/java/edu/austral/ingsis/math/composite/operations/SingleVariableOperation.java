package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;

public abstract class SingleVariableOperation implements Function {

  private final Function function;

  protected SingleVariableOperation(Function function) {
    this.function = function;
  }

  public Function getFunction() {
    return function;
  }

  @Override
  public List<String> listVariables(List<String> list) {
    return function.listVariables(list);
  }
}