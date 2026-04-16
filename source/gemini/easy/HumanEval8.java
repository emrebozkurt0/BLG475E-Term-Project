import java.util.*;
import java.lang.*;

class Solution {
    public List<Integer> sumProduct(List<Integer> numbers) {
        int sum = 0;
        int product = 1;

        for (int n : numbers) {
            sum += n;
            product *= n;
        }
        return Arrays.asList(sum, product);
    }
}

public class HumanEval8 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sumProduct(new ArrayList<>(List.of())).equals(Arrays.asList(0, 1)),
                s.sumProduct(new ArrayList<>(Arrays.asList(1, 1, 1))).equals(Arrays.asList(3, 1)),
                s.sumProduct(new ArrayList<>(Arrays.asList(100, 0))).equals(Arrays.asList(100, 0)),
                s.sumProduct(new ArrayList<>(Arrays.asList(3, 5, 7))).equals(Arrays.asList(3 + 5 + 7, 3 * 5 * 7)),
                s.sumProduct(new ArrayList<>(List.of(10))).equals(Arrays.asList(10, 10))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
