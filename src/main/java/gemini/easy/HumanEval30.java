package gemini.easy;

import java.util.*;
import java.lang.*;

public class HumanEval30 {
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
