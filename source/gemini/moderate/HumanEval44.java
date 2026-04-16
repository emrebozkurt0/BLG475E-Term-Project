import java.util.*;
import java.lang.*;

class Solution {
    public String changeBase(int x, int base) {
        StringBuilder ret = new StringBuilder();
        while (x > 0) {
            ret.append(String.valueOf(x % base));
            x /= base;
        }
        return ret.reverse().toString();
    }
}

public class HumanEval44 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.changeBase(8, 3).equals("22"),
                s.changeBase(8, 2).equals("1000"),
                s.changeBase(7, 2).equals("111"),
                s.changeBase(10, 5).equals("20"),
                s.changeBase(255, 2).equals("11111111")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
