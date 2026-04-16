import java.util.*;
import java.lang.*;

class Solution {
    public int strlen(String string) {
        return string.length();
    }
}

public class HumanEval23 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.strlen("") == 0,
                s.strlen("x") == 1,
                s.strlen("asdfgh") == 6
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
