import java.util.*;
import java.lang.*;

class Solution {
    public String fixSpaces(String text) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        int start = 0, end = 0;
        while (i < text.length()) {
            if (text.charAt(i) == ' ') {
                end++;
            } else {
                if (end - start > 0) {
                    if (end - start <= 2) {
                        for (int j = 0; j < end - start; j++) {
                            res.append('_');
                        }
                    } else {
                        res.append('-');
                    }
                }
                res.append(text.charAt(i));
                start = i + 1;
                end = i + 1;
            }
            i++;
        }
        if (end - start > 0) {
            if (end - start <= 2) {
                for (int j = 0; j < end - start; j++) {
                    res.append('_');
                }
            } else {
                res.append('-');
            }
        }
        return res.toString();
    }
}

public class HumanEval140 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.fixSpaces("Example").equals("Example"),
                s.fixSpaces("Example 1").equals("Example_1"),
                s.fixSpaces(" Example 2").equals("_Example_2"),
                s.fixSpaces(" Example   3").equals("_Example-3"),
                s.fixSpaces("a  b   c").equals("a__b-c")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
