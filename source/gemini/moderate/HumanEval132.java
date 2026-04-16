import java.util.*;
import java.lang.*;

class Solution {
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

public class HumanEval132 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.isNested("[[]]") == true,
                s.isNested("[]]]]]") == false,
                s.isNested("[][]") == false,
                s.isNested("[]") == false,
                s.isNested("[[][]]") == true,
                s.isNested("[[]][[" ) == true
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
