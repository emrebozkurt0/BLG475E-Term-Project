import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string text, replace all spaces in it with underscores, 
    and if a string has more than 2 consecutive spaces, 
    then replace all those spaces with a single dash -
    
    fix_spaces("Example") == "Example"
    fix_spaces("Example 1") == "Example_1"
    fix_spaces(" Example 2") == "_Example_2"
    fix_spaces(" Example   3") == "_Example-3"
     */
    public String fixSpaces(String text) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        int start = 0, end = 0;
        while (i < text.length()) {
            if (text.charAt(i) == ' ') {
                end++;
            } else {
                if (end - start > 0) {
                    if (end - start <= 2) {
                        for (int j = 0; j < end - start; j++) {
                            res.append('_');
                        }
                    } else {
                        res.append('-');
                    }
                }
                res.append(text.charAt(i));
                start = i + 1;
                end = i + 1;
            }
            i++;
        }
        if (end - start > 0) {
            if (end - start <= 2) {
                for (int j = 0; j < end - start; j++) {
                    res.append('_');
                }
            } else {
                res.append('-');
            }
        }
        return res.toString();
    }
}

public class HumanEval_140 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.fixSpaces("Example"), "Example"),
                Objects.equals(s.fixSpaces("M r m o n "), "M_r_m_o_n_"),
                Objects.equals(s.fixSpaces("Example rente"), "Example_rente"),
                Objects.equals(s.fixSpaces("Example   rente"), "Example-rente"),
                Objects.equals(s.fixSpaces(" Example   rente"), "_Example-rente"),
                Objects.equals(s.fixSpaces("__Ex  ample__"), "__Ex__ample__"),
                Objects.equals(s.fixSpaces("Exa   mple"), "Exa-mple")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
