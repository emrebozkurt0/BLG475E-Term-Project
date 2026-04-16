import java.util.*;
import java.lang.*;

class Solution {
    public double truncateNumber(double number) {
        return number % 1.0;
    }
}

public class HumanEval2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
            s.truncateNumber(3.5) == 0.5,
            Math.abs(s.truncateNumber(1.33) - 0.33) < 1e-6,
            Math.abs(s.truncateNumber(123.456) - 0.456) < 1e-6
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
