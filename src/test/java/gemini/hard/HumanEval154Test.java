package gemini.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HumanEval154Test {
    @Test
    public void testCycpatternCheckTrue() {
        HumanEval154 s = new HumanEval154();
        assertTrue(s.cycpatternCheck("yello", "ell"));
        assertTrue(s.cycpatternCheck("efef", "fee"));
        assertTrue(s.cycpatternCheck("winemtt", "tinem"));
        assertTrue(s.cycpatternCheck("hello", "ell"));
    }

    @Test
    public void testCycpatternCheckFalse() {
        HumanEval154 s = new HumanEval154();
        assertFalse(s.cycpatternCheck("xyzw", "xyw"));
        assertFalse(s.cycpatternCheck("whattup", "ptut"));
        assertFalse(s.cycpatternCheck("abab", "aabb"));
    }
}
