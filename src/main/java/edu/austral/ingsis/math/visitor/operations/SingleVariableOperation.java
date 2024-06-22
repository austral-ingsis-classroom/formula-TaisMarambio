package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.Visitable;

public abstract class SingleVariableOperation implements Visitable {
  private final Visitable variable;

  public SingleVariableOperation(Visitable variable) {
    this.variable = variable;
  }

  public Visitable getVariable() {
    return variable;
  }
}
