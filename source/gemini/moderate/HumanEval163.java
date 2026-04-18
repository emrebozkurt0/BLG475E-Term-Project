import java.util.*;
import java.lang.*;

public class HumanEval163 {
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
