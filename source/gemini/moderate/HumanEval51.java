import java.util.*;
import java.lang.*;

class Solution {
    public String removeVowels(String text) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if ("aeiou".indexOf(Character.toLowerCase(ch)) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

public class HumanEval51 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.removeVowels("").equals(""),
                s.removeVowels("abcdef\nghijklm").equals("bcdf\nghjklm"),
                s.removeVowels("aaaaa").equals(""),
                s.removeVowels("zbcd").equals("zbcd"),
                s.removeVowels("Hello World").equals("Hll Wrld")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
