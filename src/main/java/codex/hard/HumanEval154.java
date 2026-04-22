package codex.hard;

import java.util.*;
import java.lang.*;

public class HumanEval154 {
    public boolean cycpatternCheck(String a, String b) {
        int m = b.length();
        if (m == 0) {
            return true;
        }
        if (a.length() < m) {
            return false;
        }
        String doubled = b + b;
        for (int i = 0; i < m; i++) {
            String rotation = doubled.substring(i, i + m);
            if (a.contains(rotation)) {
                return true;
            }
        }
        return false;
    }
}
