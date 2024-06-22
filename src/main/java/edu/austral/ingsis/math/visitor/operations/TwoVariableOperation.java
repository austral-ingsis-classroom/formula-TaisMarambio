package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.Visitable;

public abstract class TwoVariableOperation implements Visitable {
  private final Visitable visitable1;
  private final Visitable visitable2;

  public TwoVariableOperation(Visitable visitable1, Visitable visitable2) {
    this.visitable1 = visitable1;
    this.visitable2 = visitable2;
  }

  public Visitable getVisitable1() {
    return visitable1;
  }

  public Visitable getVisitable2() {
    return visitable2;
  }
}
