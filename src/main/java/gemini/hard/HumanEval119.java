package gemini.hard;

import java.util.*;
import java.lang.*;

public class HumanEval119 {
    /**
    You are given a list of two strings, both strings consist of open
    parentheses "(" or close parentheses ")" only.
    Your job is to check if it is possible to concatenate the two strings in
    some order, that the resulting string will be good.
    A string S is considered to be good if and only if all parentheses in S
    are balanced. For example: the string "(())()" is good, while the string
    "())" is not.
    Return "Yes" if there"s a way to make a good string, and return "No" otherwise.

    Examples:
    matchParens(Arrays.asList("()(", ")")) == "Yes"
    matchParens(Arrays.asList(")", ")")) == "No"
     */
    public String matchParens(List<String> lst) {
        String s1 = lst.get(0) + lst.get(1);
        String s2 = lst.get(1) + lst.get(0);
        
        if (isBalanced(s1) || isBalanced(s2)) {
            return "Yes";
        }
        
        return "No";
    }
    
    private boolean isBalanced(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else if (s.charAt(i) == ')') {
                balance--;
            }
            
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}

