import java.util.*;
import java.lang.*;

class Solution {
    public int maxElement(List<Integer> l) {
        int max = l.get(0);
        for (int n : l) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}

public class HumanEval35 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.maxElement(new ArrayList<>(Arrays.asList(1, 2, 3))) == 3,
                s.maxElement(new ArrayList<>(Arrays.asList(5, 3, -5, 2, -3, 3, 9, 0, 124, 1, -10))) == 124
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
