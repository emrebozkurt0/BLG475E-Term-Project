package codex.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HumanEval154Test {

    @Test
    public void cycpatternCheck_matchesReferenceExamples() {
        HumanEval154 solution = new HumanEval154();

        assertFalse(solution.cycpatternCheck("xyzw", "xyw"));
        assertTrue(solution.cycpatternCheck("yello", "ell"));
        assertFalse(solution.cycpatternCheck("whattup", "ptut"));
        assertTrue(solution.cycpatternCheck("efef", "fee"));
        assertFalse(solution.cycpatternCheck("abab", "aabb"));
        assertTrue(solution.cycpatternCheck("winemtt", "tinem"));
    }

    @Test
    public void cycpatternCheck_returnsTrueForEmptyPattern() {
        HumanEval154 solution = new HumanEval154();

        assertTrue(solution.cycpatternCheck("anything", ""));
    }

    @Test
    public void cycpatternCheck_returnsFalseWhenSourceShorterThanPattern() {
        HumanEval154 solution = new HumanEval154();

        assertFalse(solution.cycpatternCheck("ab", "abcd"));
    }

    @Test
    public void cycpatternCheck_findsRotationNotAtInitialOffset() {
        HumanEval154 solution = new HumanEval154();

        assertTrue(solution.cycpatternCheck("zzcabyy", "abc"));
    }
}
