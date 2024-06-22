package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operations.Absolute;
import edu.austral.ingsis.math.composite.operations.Division;
import edu.austral.ingsis.math.composite.operations.Multiplication;
import edu.austral.ingsis.math.composite.operations.Parenthesis;
import edu.austral.ingsis.math.composite.operations.Power;
import edu.austral.ingsis.math.composite.operations.Substract;
import edu.austral.ingsis.math.composite.operations.Sum;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    final String result = new Sum(new Variable(1), new Variable(6)).print();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    final String result = new Division(new Variable(12), new Variable(2)).print();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    final String result = new Multiplication(new Parenthesis(new Division(new Variable(9),new Variable(2))), new Variable(3)).print();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    final String result = new Power(new Parenthesis(new Division(new Variable(27),new Variable(6))), new Variable(2)).print();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    final String result = new Substract(new Absolute(new Variable("value")), new Variable(8)).print();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    final String result = new Substract(new Absolute(new Variable("value")), new Variable(8)).print();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    final String result = new Multiplication(new Parenthesis(new Substract(new Variable(5), new Variable("i"))), new Variable(8)).print();

    assertThat(result, equalTo(expected));
  }
}
