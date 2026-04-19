package gemini.moderate;

import java.util.*;
import java.lang.*;

public class HumanEval140 {
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
