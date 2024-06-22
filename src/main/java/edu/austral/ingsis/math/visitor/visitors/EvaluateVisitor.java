package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.operations.Absolute;
import edu.austral.ingsis.math.visitor.operations.Division;
import edu.austral.ingsis.math.visitor.operations.Multiplication;
import edu.austral.ingsis.math.visitor.operations.Parenthesis;
import edu.austral.ingsis.math.visitor.operations.Power;
import edu.austral.ingsis.math.visitor.operations.Substract;
import edu.austral.ingsis.math.visitor.operations.Sum;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.Visitor;

public class EvaluateVisitor implements Visitor<Double> {
  @Override
  public Double visit(Absolute absolute) {
    return Math.abs(absolute.getVariable().accept(this));
  }

  @Override
  public Double visit(Sum sum) {
    return sum.getVisitable1().accept(this) + sum.getVisitable2().accept(this);
  }

  @Override
  public Double visit(Substract substract) {
    return substract.getVisitable1().accept(this) - substract.getVisitable2().accept(this);
  }

  @Override
  public Double visit(Division division) {
    return division.getVisitable1().accept(this) / division.getVisitable2().accept(this);
  }

  @Override
  public Double visit(Power power) {
    return Math.pow(power.getVisitable1().accept(this), power.getVisitable2().accept(this));
  }

  @Override
  public Double visit(Multiplication multiplication) {
    return multiplication.getVisitable1().accept(this) * multiplication.getVisitable2().accept(this);
  }

  @Override
  public Double visit(Variable variable) {
    return variable.getValue();
  }

  @Override
  public Double visit(Parenthesis parenthesis) {
    return parenthesis.accept(this);
  }
}
