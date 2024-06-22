package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class TwoVariableOperation implements Function {
  private final Function function1;
  private final Function function2;

  protected TwoVariableOperation(Function function1, Function function2) {
    this.function1 = function1;
    this.function2 = function2;
  }

  public Function getFunction1() {
    return function1;
  }

  public Function getFunction2() {
    return function2;
  }

  @Override
  public List<String> listVariables(List<String> list) {
    return Stream.concat(
            function1.listVariables(list).stream(), function2.listVariables(list).stream())
        .collect(Collectors.toList());
  }
}
