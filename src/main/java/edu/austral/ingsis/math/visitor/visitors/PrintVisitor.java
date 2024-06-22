package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.operations.Absolute;
import edu.austral.ingsis.math.visitor.operations.Division;
import edu.austral.ingsis.math.visitor.operations.Multiplication;
import edu.austral.ingsis.math.visitor.operations.Parenthesis;
import edu.austral.ingsis.math.visitor.operations.Power;
import edu.austral.ingsis.math.visitor.operations.Substract;
import edu.austral.ingsis.math.visitor.operations.Sum;

public class PrintVisitor implements Visitor<String> {
  @Override
  public String visit(Absolute absolute) {
    return "|" + absolute.getVariable().accept(this) + "|";
  }

  @Override
  public String visit(Sum sum) {
    return sum.getVisitable1().accept(this) + " + " + sum.getVisitable2().accept(this);
  }

  @Override
  public String visit(Substract substract) {
    return substract.getVisitable1().accept(this) + " - " + substract.getVisitable2().accept(this);
  }

  @Override
  public String visit(Division division) {
    return division.getVisitable1().accept(this) + " / " + division.getVisitable2().accept(this);
  }

  @Override
  public String visit(Power power) {
    return power.getVisitable1().accept(this) + " ^ " + power.getVisitable2().accept(this);
  }

  @Override
  public String visit(Multiplication multiplication) {
    return multiplication.getVisitable1().accept(this)
        + " * "
        + multiplication.getVisitable2().accept(this);
  }

  @Override
  public String visit(Variable variable) {
    return variable.print();
  }

  @Override
  public String visit(Parenthesis parenthesis) {
    return "(" + parenthesis.getVariable().accept(this) + ")";
  }
}
