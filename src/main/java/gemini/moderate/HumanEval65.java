package gemini.moderate;

import java.util.*;
import java.lang.*;

public class HumanEval65 {
    public String circularShift(int x, int shift) {
        String s = String.valueOf(x);
        if (shift > s.length()) {
            return new StringBuilder(s).reverse().toString();
        }

        return s.substring(s.length() - shift) + s.substring(0, s.length() - shift);
    }
}
