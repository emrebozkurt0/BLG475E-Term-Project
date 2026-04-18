import java.util.*;
import java.lang.*;

public class HumanEval_163 {
    /**
    Given two positive integers a and b, return the even digits between a
    and b, in ascending order.

    For example:
    generate_integers(2, 8) => [2, 4, 6, 8]
    generate_integers(8, 2) => [2, 4, 6, 8]
    generate_integers(10, 14) => []
     */
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
