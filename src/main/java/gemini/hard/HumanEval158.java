package gemini.hard;

import java.util.*;
import java.lang.*;

public class HumanEval158 {
    /**
    Write a function that accepts a list of strings.
    The list contains different words. Return the word with maximum number of unique characters. If multiple strings have maximum number of unique characters, return the one which comes first in lexicographical order.

    findMax(Arrays.asList("name", "of", "string")) == "string"
    findMax(Arrays.asList("name", "enam", "game")) == "enam"
    findMax(Arrays.asList("aaaaaaa", "bb", "cc")) == "aaaaaaa"
     */
    public String findMax(List<String> words) {
        String res = words.get(0);
        int maxUnique = 0;
        for (String word : words) {
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : word.toCharArray()) {
                uniqueChars.add(c);
            }
            if (uniqueChars.size() > maxUnique) {
                maxUnique = uniqueChars.size();
                res = word;
            } else if (uniqueChars.size() == maxUnique) {
                if (word.compareTo(res) < 0) {
                    res = word;
                }
            }
        }
        return res;
    }
}
