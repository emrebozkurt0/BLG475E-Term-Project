package gemini.hard;

import java.util.*;
import java.lang.*;

public class HumanEval46 {
    /**
    The Fib4 number sequence is a sequence similar to the Fibbonacci sequnece that's defined as follows:
    fib4(0) -> 0
    fib4(1) -> 0
    fib4(2) -> 2
    fib4(3) -> 0
    fib4(n) -> fib4(n-1) + fib4(n-2) + fib4(n-3) + fib4(n-4).
    Please write a function to efficiently compute the n-th element of the fib4 number sequence.  Do not use recursion.
    >>> fib4(5)
    4
    >>> fib4(6)
    8
    >>> fib4(7)
    14
     */
    public int fib4(int n) {
        List<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 2, 0));
        if (n < 4) {
            return results.get(n);
        }

        for (int i = 4; i <= n; i++) {
            results.add(results.get(i - 1) + results.get(i - 2) + results.get(i - 3) + results.get(i - 4));
        }

        return results.get(n);
    }
}
