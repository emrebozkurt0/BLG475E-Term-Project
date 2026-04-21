package codex.easy;

import java.util.*;
import java.lang.*;

public class HumanEval30 {
    /**
    Return only positive numbers in the list.
    >>> getPositive(Arrays.asList(-1, 2, -4, 5, 6))
    [2, 5, 6]
    >>> getPositive(Arrays.asList(5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10))
    [5, 3, 2, 3, 9, 123, 1]
     */
    public List<Integer> getPositive(List<Integer> l) {
        List<Integer> result = new ArrayList<>();
        for (int n : l) {
            if (n > 0) {
                result.add(n);
            }
        }
        return result;
    }
}