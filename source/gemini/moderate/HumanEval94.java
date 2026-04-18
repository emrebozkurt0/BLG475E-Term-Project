import java.util.*;
import java.lang.*;

public class HumanEval94 {
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
