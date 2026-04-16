import java.util.*;
import java.lang.*;

class Solution {
    public int skjkasdkd(List<Integer> lst) {
        int max_prime = -1;
        for (int n : lst) {
            if (n < 2) continue;
            boolean is_prime = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime && n > max_prime) {
                max_prime = n;
            }
        }
        int sum = 0;
        for (char c : String.valueOf(max_prime).toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }
}

public class HumanEval94 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.skjkasdkd(Arrays.asList(0,3,2,1,3,5,7,4,5,5,5,2,181,32,4,32,3,2,32,324,4,3)) == 10,
                s.skjkasdkd(Arrays.asList(1,0,1,8,2,4597,2,1,3,40,1,1,2,7,1)) == 25,
                s.skjkasdkd(Arrays.asList(0,724,32,71,99,10,21)) == 8,
                s.skjkasdkd(Arrays.asList(0,81,12,13,1,21)) == 4,
                s.skjkasdkd(Arrays.asList(11, 22, 33)) == 2
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
