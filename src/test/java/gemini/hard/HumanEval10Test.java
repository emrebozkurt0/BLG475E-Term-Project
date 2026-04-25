package gemini.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HumanEval10Test {
    @Test
    public void testIsPalindrome() {
        HumanEval10 s = new HumanEval10();
        assertTrue(s.isPalindrome("a"), "Single character should be a palindrome");
        assertTrue(s.isPalindrome("aba"), "Odd length palindrome should return true");
        assertFalse(s.isPalindrome("ab"), "Non-palindrome should return false");
    }

    @Test
    public void testMakePalindrome() {
        HumanEval10 s = new HumanEval10();
        assertEquals("", s.makePalindrome(null), "Null input should return empty string");
        assertEquals("", s.makePalindrome(""), "Empty string should return empty string");
        // Mutation tests for uncovered ECs: EC2 (length=1)
        assertEquals("x", s.makePalindrome("x"), "Single character should remain unchanged");
        assertEquals("xyzyx", s.makePalindrome("xyz"), "Should append reverse of prefix to make palindrome");
        assertEquals("xyx", s.makePalindrome("xyx"), "Should not modify already palindrome string");
        assertEquals("jerryrrej", s.makePalindrome("jerry"), "Should compute correct palindrome for jerry");
        // Mutation tests for uncovered ECs: EC4 (palindromic suffix length > 1)
        assertEquals("abccba", s.makePalindrome("abcc"), "Should use the longest palindromic suffix");
        
        HumanEval10 sFalse = new HumanEval10() {
            @Override
            public boolean isPalindrome(String str) {
                return false;
            }
        };
        assertEquals("abc", sFalse.makePalindrome("abc"), "Should return original when palindrome is forced to false");
    }
}
