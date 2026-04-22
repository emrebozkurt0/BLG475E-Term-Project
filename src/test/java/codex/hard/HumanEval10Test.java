package codex.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HumanEval10Test {
    @Test
    public void testSolution() {
        HumanEval10 s = new HumanEval10();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.makePalindrome(""), ""),
                Objects.equals(s.makePalindrome("x"), "x"),
                Objects.equals(s.makePalindrome("xyz"), "xyzyx"),
                Objects.equals(s.makePalindrome("xyx"), "xyx"),
                Objects.equals(s.makePalindrome("jerry"), "jerryrrej")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
