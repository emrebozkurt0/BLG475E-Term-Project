package codex.moderate;

import java.util.*;
import java.lang.*;

public class HumanEval_132 {
    /**
    Create a function that takes a string as input which contains only square brackets.
    The function should return true if there are any mansions of brackets nested such that at least one bracket contains a nested bracket.

    is_nested('[[]]') ➞ True
    is_nested('[]]]]]') ➞ False
    is_nested('[][]') ➞ False
    is_nested('[]') ➞ False
    is_nested('[[][]]') ➞ True
    is_nested('[[]][[' ) ➞ True
     */
    public boolean isNested(String string) {
        int count = 0;
        boolean sawNestedDepth = false;
        boolean closedAfterNesting = false;
        for (char c : string.toCharArray()) {
            if (c == '[') {
                count++;
                if (count >= 2) {
                    sawNestedDepth = true;
                }
            } else if (c == ']') {
                count--;
                if (count < 0) {
                    return false;
                }
                if (sawNestedDepth && count == 0) {
                    closedAfterNesting = true;
                }
            }
        }
        return sawNestedDepth && closedAfterNesting;
    }
}
