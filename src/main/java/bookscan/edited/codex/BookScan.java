/* @Authors
* Student Names: Mustafa Berkay Arslan, Emre Bozkurt, Harun Yahya Demirpençe
* Student IDs: 150210023, 150210030, 150210022
*/
package bookscan.edited.codex;

import java.util.*;

public class BookScan {
    /** Returns the length of the given string. */
    public int strlen(String string) {
        if (string == null) {
            return 0;
        }
        return string.length();
    }

    /** Returns how many times substring occurs in string, counting overlaps. */
    public int howManyTimes(String string, String substring) {
        if (string == null || substring == null) {
            return 0;
        }
        if (substring.equals("")) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while (index <= string.length() - substring.length()) {
            if (string.regionMatches(index, substring, 0, substring.length())) {
                count++;
                index++;
            } else {
                index++;
            }
        }
        return count;
    }

    /** Returns a new string with each letter's case flipped. */
    public String flipCase(String string) {
        if (string == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                builder.append((char) (ch - ('a' - 'A')));
            } else if (ch >= 'A' && ch <= 'Z') {
                builder.append((char) (ch + ('a' - 'A')));
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    /** Scans text and returns qualifying words with 1-based line occurrences. */
    public Map<String, List<Integer>> scan(String text, int wordLength) {
        if (wordLength <= 0) {
            throw new IllegalArgumentException("wordLength must be positive");
        }
        Map<String, List<Integer>> result = new LinkedHashMap<>();
        if (text == null || strlen(text) == 0) {
            return result;
        }

        String[] lines = text.split("\n", -1);
        Map<String, String> keyByNormalized = new HashMap<>();

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            int lineNumber = i + 1;
            String[] tokens = line.split("[\\s\\p{Punct}]+", -1);

            List<String> normalizedTokens = new ArrayList<>();
            for (String token : tokens) {
                if (strlen(token) == 0) {
                    continue;
                }
                if (strlen(token) != wordLength) {
                    continue;
                }
                String normalized = normalize(token);
                normalizedTokens.add(normalized);
                if (!keyByNormalized.containsKey(normalized)) {
                    keyByNormalized.put(normalized, token);
                    result.put(token, new ArrayList<>());
                }
            }

            if (normalizedTokens.isEmpty()) {
                continue;
            }

            String joined = joinTokens(normalizedTokens);
            Map<String, Integer> lineCounts = new HashMap<>();
            for (String normalized : normalizedTokens) {
                if (!lineCounts.containsKey(normalized)) {
                    int count = howManyTimes(joined, "|" + normalized + "|");
                    lineCounts.put(normalized, count);
                }
            }

            for (Map.Entry<String, Integer> entry : lineCounts.entrySet()) {
                String normalized = entry.getKey();
                int count = entry.getValue();
                String key = keyByNormalized.get(normalized);
                List<Integer> linesList = result.get(key);
                for (int c = 0; c < count; c++) {
                    linesList.add(lineNumber);
                }
            }
        }

        return result;
    }

    /** Returns the total count of all occurrences in scan. */
    public int totalOccurrences(String text, int wordLength) {
        if (wordLength <= 0) {
            throw new IllegalArgumentException("wordLength must be positive");
        }
        if (text == null || strlen(text) == 0) {
            return 0;
        }
        Map<String, List<Integer>> result = scan(text, wordLength);
        int total = 0;
        for (List<Integer> lines : result.values()) {
            total += lines.size();
        }
        return total;
    }

    private String normalize(String word) {
        return flipCase(word).toLowerCase(Locale.ROOT);
    }

    private String joinTokens(List<String> tokens) {
        StringBuilder builder = new StringBuilder();
        builder.append('|');
        for (int i = 0; i < tokens.size(); i++) {
            builder.append(tokens.get(i)).append('|');
        }
        return builder.toString();
    }
}
