package gemini.moderate;

import java.util.*;
import java.lang.*;

public class HumanEval75 {
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
