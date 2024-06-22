package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operations.Absolute;
import edu.austral.ingsis.math.visitor.operations.Division;
import edu.austral.ingsis.math.visitor.operations.Multiplication;
import edu.austral.ingsis.math.visitor.operations.Parenthesis;
import edu.austral.ingsis.math.visitor.operations.Power;
import edu.austral.ingsis.math.visitor.operations.Substract;
import edu.austral.ingsis.math.visitor.operations.Sum;

public interface Visitor<T> {

  T visit(Absolute absolute);

  T visit(Sum sum);

  T visit(Substract substract);

  T visit(Division division);

  T visit(Power power);

  T visit(Multiplication multiplication);

  T visit(Variable variable);

  T visit(Parenthesis parenthesis);
}
