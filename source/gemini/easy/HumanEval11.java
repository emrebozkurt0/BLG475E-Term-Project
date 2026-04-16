import java.util.*;
import java.lang.*;

class Solution {
    public String stringXor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                result.append("0");
            } else {
                result.append("1");
            }
        }
        return result.toString();
    }
}

public class HumanEval11 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.stringXor("111000", "101010"), "010010"),
                Objects.equals(s.stringXor("1", "1"), "0"),
                Objects.equals(s.stringXor("0101", "0000"), "0101")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
