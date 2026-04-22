package codex.hard;

import java.util.*;
import java.lang.*;

public class HumanEval153 {
    public String StrongestExtension(String class_name, List<String> extensions) {
        String best = extensions.get(0);
        int bestStrength = strength(best);
        for (int i = 1; i < extensions.size(); i++) {
            String cur = extensions.get(i);
            int curStrength = strength(cur);
            if (curStrength > bestStrength) {
                bestStrength = curStrength;
                best = cur;
            }
        }

        return class_name + "." + best;
    }

    private int strength(String s) {
        int upper = 0;
        int lower = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                upper++;
            } else if (Character.isLowerCase(ch)) {
                lower++;
            }
        }
        return upper - lower;
    }
}
