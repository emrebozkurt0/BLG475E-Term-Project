import java.util.*;
import java.lang.*;

class Solution {
    public List<Integer> generateIntegers(int a, int b) {
        List<Integer> result = new ArrayList<>();
        int lower = Math.min(a, b);
        int upper = Math.max(a, b);
        for (int i = lower; i <= Math.min(upper, 9); i++) {
            if (i % 2 == 0) {
                result.add(i);
            }
        }
        return result;
    }
}

public class HumanEval163 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.generateIntegers(2, 8).equals(Arrays.asList(2, 4, 6, 8)),
                s.generateIntegers(8, 2).equals(Arrays.asList(2, 4, 6, 8)),
                s.generateIntegers(10, 14).equals(Arrays.asList()),
                s.generateIntegers(1, 5).equals(Arrays.asList(2, 4)),
                s.generateIntegers(9, 9).equals(Arrays.asList())
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
