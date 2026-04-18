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
        int count = 0, max_depth = 0;
        for (char c : string.toCharArray()) {
            if (c == '[') {
                count++;
                max_depth = Math.max(max_depth, count);
            } else if (c == ']') {
                count--;
            }
        }
        return max_depth >= 2;
    }
}
