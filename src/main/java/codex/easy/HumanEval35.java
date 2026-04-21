package codex.easy;

import java.util.*;
import java.lang.*;

public class HumanEval35 {
    /**
    Return maximum element in the list.
    >>> maxElement(Arrays.asList(1, 2, 3))
    3
    >>> maxElement(Arrays.asList(5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10))
    123
     */
    public int maxElement(List<Integer> l) {
        int max = l.get(0);
        for (int n : l) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}