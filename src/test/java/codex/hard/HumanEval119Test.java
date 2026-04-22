package codex.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval119Test {

    @Test
    public void matchParens_returnsYesWhenFirstConcatenationIsValid() {
        HumanEval119 solution = new HumanEval119();

        assertEquals("Yes", solution.matchParens(Arrays.asList("()(", ")")));
        assertEquals("Yes", solution.matchParens(Arrays.asList("(()(", "()))()")));
    }

    @Test
    public void matchParens_returnsYesWhenSecondConcatenationIsValid() {
        HumanEval119 solution = new HumanEval119();

        assertEquals("Yes", solution.matchParens(Arrays.asList(")())", "(()()(")));
        assertEquals("Yes", solution.matchParens(Arrays.asList("(())))", "(()())((")));
    }

    @Test
    public void matchParens_returnsNoWhenBothConcatenationsAreInvalid() {
        HumanEval119 solution = new HumanEval119();

        assertEquals("No", solution.matchParens(Arrays.asList(")", ")")));
        assertEquals("No", solution.matchParens(Arrays.asList("(()(())", "())())")));
        assertEquals("No", solution.matchParens(Arrays.asList("()", "())")));
        assertEquals("No", solution.matchParens(Arrays.asList("((((", "((())")));
        assertEquals("No", solution.matchParens(Arrays.asList(")(()", "(()(")));
        assertEquals("No", solution.matchParens(Arrays.asList(")(", ")(")));
    }

    @Test
    public void matchParens_handlesEmptyInputs() {
        HumanEval119 solution = new HumanEval119();

        assertEquals("Yes", solution.matchParens(Arrays.asList("", "")));
        assertEquals("No", solution.matchParens(Arrays.asList("(", "")));
    }
}
