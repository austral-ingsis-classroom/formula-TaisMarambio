package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

public class Power extends TwoVariableOperation {

  public Power(Visitable visitable1, Visitable visitable2) {
    super(visitable1, visitable2);
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
