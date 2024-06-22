package edu.austral.ingsis.math.composite;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.composite.operations.Absolute;
import edu.austral.ingsis.math.composite.operations.Division;
import edu.austral.ingsis.math.composite.operations.Multiplication;
import edu.austral.ingsis.math.composite.operations.Power;
import edu.austral.ingsis.math.composite.operations.Substract;
import edu.austral.ingsis.math.composite.operations.Sum;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double result = new Sum(new Variable(1), new Variable(6)).evaluate();

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double result = new Division(new Variable(12), new Variable(2)).evaluate();

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double result =
        new Multiplication(new Division(new Variable(9), new Variable(2)), new Variable(3))
            .evaluate();

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double result =
        new Power(new Division(new Variable(27), new Variable(6)), new Variable(2)).evaluate();

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double result =
        new Power(new Variable(36), new Division(new Variable(1), new Variable(2))).evaluate();

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = new Absolute(new Variable(136)).evaluate();

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = new Absolute(new Variable(-136)).evaluate();

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result =
        new Multiplication(new Substract(new Variable(5), new Variable(5)), new Variable(8))
            .evaluate();

    assertThat(result, equalTo(0d));
  }
}
