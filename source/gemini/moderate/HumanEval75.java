import java.util.*;
import java.lang.*;

class Solution {
    public boolean isMultiplyPrime(int a) {
        int count = 0;
        for (int i = 2; i <= a; i++) {
            boolean is_prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime) {
                while (a % i == 0) {
                    count++;
                    a /= i;
                }
            }
        }
        return count == 3;
    }
}

public class HumanEval75 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.isMultiplyPrime(30) == true,
                s.isMultiplyPrime(8) == true,
                s.isMultiplyPrime(10) == false,
                s.isMultiplyPrime(12) == true,
                s.isMultiplyPrime(105) == true
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
