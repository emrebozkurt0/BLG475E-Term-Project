package codex.moderate;

import java.util.*;
import java.lang.*;

public class HumanEval_140 {
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
