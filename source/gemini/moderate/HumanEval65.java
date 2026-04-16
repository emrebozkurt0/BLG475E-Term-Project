import java.util.*;
import java.lang.*;

class Solution {
    public String circularShift(int x, int shift) {
        String s = String.valueOf(x);
        if (shift > s.length()) {
            return new StringBuilder(s).reverse().toString();
        }

        return s.substring(s.length() - shift) + s.substring(0, s.length() - shift);
    }
}

public class HumanEval65 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.circularShift(12, 1).equals("21"),
                s.circularShift(12, 2).equals("12"),
                s.circularShift(12345, 2).equals("45123"),
                s.circularShift(1234, 10).equals("4321"),
                s.circularShift(100, 1).equals("010")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
