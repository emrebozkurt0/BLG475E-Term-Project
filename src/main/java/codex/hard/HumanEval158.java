package codex.hard;

import java.util.*;
import java.lang.*;

public class HumanEval158 {
    public String findMax(List<String> words) {
        String best = words.get(0);
        int bestUnique = countUnique(best);

        for (int i = 1; i < words.size(); i++) {
            String current = words.get(i);
            int currentUnique = countUnique(current);

            if (currentUnique > bestUnique) {
                best = current;
                bestUnique = currentUnique;
            } else if (currentUnique == bestUnique && current.compareTo(best) < 0) {
                best = current;
            }
        }

        return best;
    }

    private int countUnique(String s) {
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            seen.add(s.charAt(i));
        }
        return seen.size();
    }
}
