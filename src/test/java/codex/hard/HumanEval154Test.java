package codex.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HumanEval154Test {
    @Test
    public void testSolution() {
        HumanEval154 s = new HumanEval154();
        List<Boolean> correct = Arrays.asList(
                s.cycpatternCheck("xyzw", "xyw") == false,
                s.cycpatternCheck("yello", "ell") == true,
                s.cycpatternCheck("whattup", "ptut") == false,
                s.cycpatternCheck("efef", "fee") == true,
                s.cycpatternCheck("abab", "aabb") == false,
                s.cycpatternCheck("winemtt", "tinem") == true
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
