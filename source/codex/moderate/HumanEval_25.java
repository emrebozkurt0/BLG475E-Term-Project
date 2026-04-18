import java.util.*;
import java.lang.*;

public class HumanEval_25 {
    /**
    Return list of prime factors of given integer in the order from smallest to largest.
    Each of the factors should be listed number of times corresponding to how many times it appeares in factorization.
    Input number should be equal to the product of all factors
    >>> factorize(8)
    [2, 2, 2]
    >>> factorize(25)
    [5, 5]
    >>> factorize(70)
    [2, 5, 7]
     */
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
