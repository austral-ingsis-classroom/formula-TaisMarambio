package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operations.Absolute;
import edu.austral.ingsis.math.composite.operations.Division;
import edu.austral.ingsis.math.composite.operations.Multiplication;
import edu.austral.ingsis.math.composite.operations.Power;
import edu.austral.ingsis.math.composite.operations.Substract;
import edu.austral.ingsis.math.composite.operations.Sum;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Double result = new Sum(new Variable(1), new Variable("x", 3)).evaluate();

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Double result = new Division(new Variable(12), new Variable("div", 4)).evaluate();

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double result = new Multiplication(new Division(new Variable(9), new Variable("x", 3)), new Variable("y", 4)).evaluate();

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double result = new Power(new Division(new Variable(27), new Variable("a", 9)), new Variable("b", 3)).evaluate();

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double result = new Power(new Variable("z", 36), new Division(new Variable(1), new Variable(2))).evaluate();

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double result = new Substract(new Absolute(new Variable("value", 8)), new Variable(8)).evaluate();

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Double result = new Substract(new Absolute(new Variable("value", 8)), new Variable(8)).evaluate();

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double result = new Multiplication(new Substract(new Variable(5), new Variable("i", 2)), new Variable(8)).evaluate();

    assertThat(result, equalTo(24d));
  }
}
