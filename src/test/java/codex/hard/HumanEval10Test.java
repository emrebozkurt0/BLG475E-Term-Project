package codex.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HumanEval10Test {

    @Test
    public void makePalindrome_returnsSameForEmptyString() {
        HumanEval10 solution = new HumanEval10();
        assertEquals("", solution.makePalindrome(""));
    }

    @Test
    public void makePalindrome_returnsSameForSingleCharacter() {
        HumanEval10 solution = new HumanEval10();
        assertEquals("x", solution.makePalindrome("x"));
    }

    @Test
    public void makePalindrome_buildsExpectedForNonPalindrome() {
        HumanEval10 solution = new HumanEval10();
        String result = solution.makePalindrome("xyz");

        assertEquals("xyzyx", result);
        assertTrue(solution.isPalindrome(result));
    }

    @Test
    public void makePalindrome_keepsExistingPalindromeUnchanged() {
        HumanEval10 solution = new HumanEval10();
        assertEquals("xyx", solution.makePalindrome("xyx"));
    }

    @Test
    public void makePalindrome_appendsShortestSuffixForTypicalInput() {
        HumanEval10 solution = new HumanEval10();
        String result = solution.makePalindrome("jerry");

        assertEquals("jerryrrej", result);
        assertTrue(solution.isPalindrome(result));
    }
}
