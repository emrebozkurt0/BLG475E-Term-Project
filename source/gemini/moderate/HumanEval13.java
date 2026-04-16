import java.util.*;
import java.lang.*;

class Solution {
    public int greatestCommonDivisor(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        if (a == b) {
            return a;
        }
        if (a > b) {
            return greatestCommonDivisor(a % b, b);
        } else {
            return greatestCommonDivisor(a, b % a);
        }
    }
}

public class HumanEval13 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.greatestCommonDivisor(3, 5) == 1,
                s.greatestCommonDivisor(25, 15) == 5,
                s.greatestCommonDivisor(100, 100) == 100,
                s.greatestCommonDivisor(14, 21) == 7,
                s.greatestCommonDivisor(101, 103) == 1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
