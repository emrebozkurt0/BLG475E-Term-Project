package gemini.easy;

import java.util.*;
import java.lang.*;

public class HumanEval35 {
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
