package gemini.hard;

import java.util.*;
import java.lang.*;

public class HumanEval10 {
    /**
    Test if given string is a palindrome
     */
    public boolean isPalindrome(String string) {
        int i = 0;
        int j = string.length() - 1;
        while (i < j) {
            if (string.charAt(i)!= string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    /**
    Find the shortest palindrome that begins with a supplied string.
    Algorithm idea is simple:
    - Find the longest postfix of supplied string that is a palindrome.
    - Append to the end of the string reverse of a string prefix that comes before the palindromic suffix.
    >>> makePalindrome("")
    ""
    >>> makePalindrome("cat")
    "catac"
    >>> makePalindrome("cata")
    "catac"
     */
    public String makePalindrome(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        
        // Find the longest palindromic postfix
        // by checking progressively smaller substrings starting from i
        for (int i = 0; i < string.length(); i++) {
            if (isPalindrome(string.substring(i))) {
                // The postfix starting at index 'i' is a palindrome
                // The prefix before this palindromic suffix is string.substring(0, i)
                String prefix = string.substring(0, i);
                
                // Append the reverse of the prefix to the end of the original string
                return string + new StringBuilder(prefix).reverse().toString();
            }
        }
        
        return string;
    }
}
