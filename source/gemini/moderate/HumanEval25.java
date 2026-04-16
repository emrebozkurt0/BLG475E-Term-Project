import java.util.*;
import java.lang.*;

class Solution {
    public List<Integer> factorize(int n) {
        List<Integer> result = new ArrayList<>();
        int i = 2;
        while (i <= (int) (Math.sqrt(n) + 1.0)) {
            if (n % i == 0) {
                result.add(i);
                n /= i;
            } else {
                i++;
            }
        }

        if (n > 1) {
            result.add(n);
        }
        return result;
    }
}

public class HumanEval25 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.factorize(8).equals(Arrays.asList(2, 2, 2)),
                s.factorize(25).equals(Arrays.asList(5, 5)),
                s.factorize(70).equals(Arrays.asList(2, 5, 7)),
                s.factorize(11).equals(Arrays.asList(11)),
                s.factorize(100).equals(Arrays.asList(2, 2, 5, 5))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
