import java.util.*;
import java.lang.*;

public class HumanEval_94 {
    /**
    You are given a list of integers.
    You need to find the largest prime value and return the sum of its digits.

    Examples:
    >>> skjkasdkd(Arrays.asList(0,3,2,1,3,5,7,4,5,5,5,2,181,32,4,32,3,2,32,324,4,3)) == 10
    >>> skjkasdkd(Arrays.asList(1,0,1,8,2,4597,2,1,3,40,1,1,2,7,1)) == 25
    >>> skjkasdkd(Arrays.asList(1,3,1,32,6,5,1,2,3,2,3,2,7,3273)) == 12
    >>> skjkasdkd(Arrays.asList(0,724,32,71,99,10,21)) == 8
    >>> skjkasdkd(Arrays.asList(0,81,12,13,1,21)) == 4
    >>> skjkasdkd(Arrays.asList(0,8,1,2,1,7)) == 7
     */
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
