package bookscan.unmodified.codex;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class BookScan {

    /**
     * Find how many times a given substring can be found in the original string. Count overlaping cases.
     * >>> howManyTimes("", "a")
     * 0
     * >>> howManyTimes("aaa", "a")
     * 3
     * >>> howManyTimes("aaaa", "aa")
     * 3
     */
    public int howManyTimes(String string, String substring) {
        if (string == null || substring == null || substring.isEmpty()) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = string.indexOf(substring, index)) != -1) {
            count++;
            index += 1; // allow overlaps
        }
        return count;
    }

    /**
     * Return length of given string
     * >>> strlen("")
     * 0
     * >>> strlen("abc")
     * 3
     */
    public int strlen(String string) {
        if (string == null) {
            return 0;
        }
        return string.length();
    }

    /**
     * For a given string, flip lowercase characters to uppercase and uppercase to lowercase.
     * >>> flipCase("Hello")
     * "hELLO"
     */
    public String flipCase(String string) {
        if (string == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (Character.isLowerCase(c)) {
                builder.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                builder.append(Character.toLowerCase(c));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    /**
     * Scan a multi-line text and return a map from word to the list of line numbers it appears on.
     * Words are grouped case-insensitively under the first seen casing.
     */
    public Map<String, List<Integer>> scan(String text, int wordLength) {
        if (text == null || text.isEmpty()) {
            return new LinkedHashMap<>();
        }
        if (wordLength <= 0) {
            throw new IllegalArgumentException("wordLength must be positive");
        }

        Map<String, List<Integer>> result = new LinkedHashMap<>();
        Map<String, String> canonicalToDisplay = new LinkedHashMap<>();

        String[] lines = text.split("\n", -1);
        for (int lineIndex = 0; lineIndex < lines.length; lineIndex++) {
            String line = lines[lineIndex];
            if (line.isEmpty()) {
                continue;
            }

            String[] tokens = line.split("[^\\p{L}\\p{Nd}]+", -1);
            List<String> canonicalTokens = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    String canonical = flipCase(token).toLowerCase(Locale.ROOT);
                    canonicalTokens.add(canonical);
                }
            }
            if (canonicalTokens.isEmpty()) {
                continue;
            }

            StringBuilder normalizedLine = new StringBuilder();
            for (int i = 0; i < canonicalTokens.size(); i++) {
                if (i > 0) {
                    normalizedLine.append(' ');
                }
                normalizedLine.append(canonicalTokens.get(i));
            }
            String paddedLine = " " + normalizedLine + " ";

            Set<String> processed = new HashSet<>();
            for (int i = 0; i < tokens.length; i++) {
                String token = tokens[i];
                if (token.isEmpty()) {
                    continue;
                }
                if (strlen(token) != wordLength) {
                    continue;
                }

                String canonical = flipCase(token).toLowerCase(Locale.ROOT);
                if (!processed.add(canonical)) {
                    continue;
                }

                int occurrences = howManyTimes(paddedLine, " " + canonical + " ");
                if (occurrences == 0) {
                    continue;
                }

                String display = canonicalToDisplay.computeIfAbsent(canonical, k -> token);
                List<Integer> linesList = result.computeIfAbsent(display, k -> new ArrayList<>());
                int lineNumber = lineIndex + 1;
                for (int j = 0; j < occurrences; j++) {
                    linesList.add(lineNumber);
                }
            }
        }

        return result;
    }

    /**
     * Return total number of occurrences for a given word length.
     */
    public int totalOccurrences(String text, int wordLength) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        if (wordLength <= 0) {
            throw new IllegalArgumentException("wordLength must be positive");
        }

        int total = 0;
        Map<String, List<Integer>> map = scan(text, wordLength);
        for (List<Integer> lines : map.values()) {
            total += lines.size();
        }
        return total;
    }
}
