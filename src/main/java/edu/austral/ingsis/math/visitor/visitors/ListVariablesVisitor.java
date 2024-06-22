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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListVariablesVisitor implements Visitor<List<String>> {

  private List<String> merge(List<String> a, List<String> b) {
    return Stream.concat(a.stream(), b.stream()).collect(Collectors.toList());
  }

  @Override
  public List<String> visit(Absolute absolute) {
    return absolute.getVariable().accept(this);
  }

  @Override
  public List<String> visit(Sum sum) {
    return merge(sum.getVisitable1().accept(this), sum.getVisitable2().accept(this));
  }

  @Override
  public List<String> visit(Substract substract) {
    return merge(substract.getVisitable1().accept(this), substract.getVisitable2().accept(this));
  }

  @Override
  public List<String> visit(Division division) {
    return merge(division.getVisitable1().accept(this), division.getVisitable2().accept(this));
  }

  @Override
  public List<String> visit(Power power) {
    return merge(power.getVisitable1().accept(this), power.getVisitable2().accept(this));
  }

  @Override
  public List<String> visit(Multiplication multiplication) {
    return merge(multiplication.getVisitable1().accept(this), multiplication.getVisitable2().accept(this));
  }

  @Override
  public List<String> visit(Variable variable) {
    if (variable.isVariable()){
      return List.of(variable.print());
    }else {
      return List.of();
    }
  }

  @Override
  public List<String> visit(Parenthesis parenthesis) {
    return parenthesis.accept(this);
  }
}
