package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operations.*;
import edu.austral.ingsis.math.visitor.visitors.PrintVisitor;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {
  private final PrintVisitor printVisitor = new PrintVisitor();

  /**
   * Case 1 + 6
   */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    final String result = printVisitor.visit(new Sum(new Variable(1), new Variable(6)));

    assertThat(result, equalTo(expected));
  }

  /**
   * Case 12 / 2
   */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    final String result = printVisitor.visit(new Division(new Variable(12), new Variable(2)));

    assertThat(result, equalTo(expected));
  }

  /**
   * Case (9 / 2) * 3
   */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    final String result = printVisitor.visit(new Multiplication(new Parenthesis(new Division(new Variable(9), new Variable(2))), new Variable(3)));

    assertThat(result, equalTo(expected));
  }

  /**
   * Case (27 / 6) ^ 2
   */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    final String result = printVisitor.visit(new Power(new Parenthesis(new Division(new Variable(27), new Variable(6))), new Variable(2)));

    assertThat(result, equalTo(expected));
  }

  /**
   * Case |value| - 8
   */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    final String result = printVisitor.visit(new Substract(new Absolute(new Variable("value")), new Variable(8)));

    assertThat(result, equalTo(expected));
  }

  /**
   * Case |value| - 8
   */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    final String result = printVisitor.visit(new Substract(new Absolute(new Variable("value")), new Variable(8)));

    assertThat(result, equalTo(expected));
  }

  /**
   * Case (5 - i) * 8
   */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    final String result = printVisitor.visit(new Multiplication(new Parenthesis(new Substract(new Variable(5), new Variable("i"))), new Variable(8)));

    assertThat(result, equalTo(expected));
  }
}