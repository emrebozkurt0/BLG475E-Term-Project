package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class HumanEval119Test {
    @Test
    public void testSolution() {
        HumanEval119 s = new HumanEval119();
        List<Boolean> correct = Arrays.asList(
                s.matchParens(Arrays.asList("()(", ")")).equals("Yes"),
                s.matchParens(Arrays.asList(")", ")")).equals("No"),
                s.matchParens(Arrays.asList("(()(())", "())())")).equals("No"),
                s.matchParens(Arrays.asList(")())", "(()()(")).equals("Yes"),
                s.matchParens(Arrays.asList("(())))", "(()())((")).equals("Yes"),
                s.matchParens(Arrays.asList("()", "())")).equals("No"),
                s.matchParens(Arrays.asList("(()(", "()))()")).equals("Yes"),
                s.matchParens(Arrays.asList("((((", "((())")).equals("No"),
                s.matchParens(Arrays.asList(")(()", "(()(")).equals("No"),
                s.matchParens(Arrays.asList(")(", ")(")).equals("No")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
