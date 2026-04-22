package codex.hard;

import java.util.*;
import java.lang.*;

public class HumanEval119 {
    public String matchParens(List<String> lst) {
        String s1 = lst.get(0) + lst.get(1);
        String s2 = lst.get(1) + lst.get(0);

        if (isGood(s1) || isGood(s2)) {
            return "Yes";
        }
        return "No";
    }

    private boolean isGood(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}

