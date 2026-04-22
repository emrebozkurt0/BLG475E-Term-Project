package gemini.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HumanEval154Test {
    @Test
    public void testCycpatternCheck() {
        HumanEval154 s = new HumanEval154();

        String[][] trueCases = {
            {"yello", "ell"},
            {"efef", "fee"},
            {"winemtt", "tinem"},
            {"hello", "ell"}
        };

        for (String[] tc : trueCases) {
            assertTrue(s.cycpatternCheck(tc[0], tc[1]), 
                "cycpatternCheck should return true for: " + tc[0] + ", " + tc[1]);
        }

        String[][] falseCases = {
            {"xyzw", "xyw"},
            {"whattup", "ptut"},
            {"abab", "aabb"}
        };

        for (String[] fc : falseCases) {
            assertFalse(s.cycpatternCheck(fc[0], fc[1]), 
                "cycpatternCheck should return false for: " + fc[0] + ", " + fc[1]);
        }
    }
}
