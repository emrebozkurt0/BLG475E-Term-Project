package codex.moderate;

import java.util.*;
import java.lang.*;

public class HumanEval_75 {
    /**
    Write a function that returns true if the given number is the product of 3 prime numbers
    and false otherwise.
    Knowing that the given number is less than 100.
    Example:
    isMultiplyPrime(30) == true
    30 = 2 * 3 * 5
     */
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
