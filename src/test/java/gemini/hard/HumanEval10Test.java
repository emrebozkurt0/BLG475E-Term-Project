package gemini.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HumanEval10Test {
    @Test
    public void testIsPalindrome() {
        HumanEval10 s = new HumanEval10();
        assertTrue(s.isPalindrome(""));
        assertTrue(s.isPalindrome("a"));
        assertTrue(s.isPalindrome("aba"));
        assertFalse(s.isPalindrome("ab"));
    }

    @Test
    public void testMakePalindromeEmpty() {
        HumanEval10 s = new HumanEval10();
        assertEquals("", s.makePalindrome(""));
        assertEquals("", s.makePalindrome(null));
    }

    @Test
    public void testMakePalindromeBase() {
        HumanEval10 s = new HumanEval10();
        assertEquals("x", s.makePalindrome("x"));
        assertEquals("xyzyx", s.makePalindrome("xyz"));
        assertEquals("xyx", s.makePalindrome("xyx"));
        assertEquals("jerryrrej", s.makePalindrome("jerry"));
    }

    @Test
    public void testMakePalindromeUnreachableBranch() {
        HumanEval10 s = new HumanEval10() {
            @Override
            public boolean isPalindrome(String string) {
                return false;
            }
        };
        assertEquals("abc", s.makePalindrome("abc"));
    }
}
