package edu.austral.ingsis.math.composite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.composite.operations.Division;
import edu.austral.ingsis.math.composite.operations.Multiplication;
import edu.austral.ingsis.math.composite.operations.Power;
import edu.austral.ingsis.math.composite.operations.Substract;
import edu.austral.ingsis.math.composite.operations.Sum;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final List<String> result =
        new Sum(new Variable(1), new Variable(6)).listVariables(new ArrayList<>());

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final List<String> result =
        new Division(new Variable(12), new Variable("div")).listVariables(new ArrayList<>());
    System.out.println(result.size());

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final List<String> result =
        new Multiplication(new Division(new Variable(9), new Variable("x")), new Variable("y"))
            .listVariables(new ArrayList<>());

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final List<String> result =
        new Power(new Division(new Variable(27), new Variable("a")), new Variable("b"))
            .listVariables(new ArrayList<>());

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final List<String> result =
        new Power(new Variable("z"), new Division(new Variable(1), new Variable(2)))
            .listVariables(new ArrayList<>());

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final List<String> result =
        new Sum(new Variable("value"), new Variable(8)).listVariables(new ArrayList<>());

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final List<String> result =
        new Sum(new Variable("value"), new Variable(8)).listVariables(new ArrayList<>());

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final List<String> result =
        new Multiplication(new Substract(new Variable(5), new Variable("i")), new Variable(8))
            .listVariables(new ArrayList<>());

    assertThat(result, containsInAnyOrder("i"));
  }
}
