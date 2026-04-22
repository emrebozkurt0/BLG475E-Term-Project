package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval119Test {
    @Test
    public void testMatchParensValid1() {
        HumanEval119 s = new HumanEval119();
        assertEquals("Yes", s.matchParens(Arrays.asList("()(", ")")));
    }

    @Test
    public void testMatchParensValid2() {
        HumanEval119 s = new HumanEval119();
        assertEquals("Yes", s.matchParens(Arrays.asList(")())", "(()()(")));
        assertEquals("Yes", s.matchParens(Arrays.asList("(())))", "(()())((")));
        assertEquals("Yes", s.matchParens(Arrays.asList("(()(", "()))()")));
    }

    @Test
    public void testMatchParensInvalid1() {
        HumanEval119 s = new HumanEval119();
        assertEquals("No", s.matchParens(Arrays.asList(")", ")")));
        assertEquals("No", s.matchParens(Arrays.asList("(()(())", "())())")));
    }

    @Test
    public void testMatchParensInvalid2() {
        HumanEval119 s = new HumanEval119();
        assertEquals("No", s.matchParens(Arrays.asList("()", "())")));
        assertEquals("No", s.matchParens(Arrays.asList("((((", "((())")));
        assertEquals("No", s.matchParens(Arrays.asList(")(()", "(()(")));
        assertEquals("No", s.matchParens(Arrays.asList(")(", ")(")));
    }

    @Test
    public void testMatchParensInvalidChar() {
        HumanEval119 s = new HumanEval119();
        assertEquals("Yes", s.matchParens(Arrays.asList("a", "b")));
    }
}
