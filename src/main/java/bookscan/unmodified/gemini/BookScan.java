package bookscan.unmodified.gemini;

import java.util.*;

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
            index++; // Increment by 1 to count overlapping words
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
     * Determines how many times words of a given length appear in a text (list of lines),
     * and in which lines they appear, utilizing the three methods above.
     */
    public void scanAndDisplayStats(List<String> textLines, int targetLength) {
        Map<String, List<Integer>> wordToLines = new HashMap<>();

        for (int i = 0; i < textLines.size(); i++) {
            String originalLine = textLines.get(i);
            
            // Example usage of flipCase to manipulate or test text cases (creating a flipped version for search if needed)
            String flippedLine = flipCase(originalLine);
            
            // Extract raw words
            String[] words = originalLine.split("\\s+");
            
            for (String word : words) {
                // Ensure word matches the requested length constraint
                if (strlen(word) == targetLength) {
                    
                    // We can check how many times this specific word occurred in the line
                    int occurrencesInLine = howManyTimes(originalLine, word);
                    
                    if (occurrencesInLine > 0) {
                        wordToLines.computeIfAbsent(word, k -> new ArrayList<>()).add(i + 1);
                    }
                }
            }
        }

        // Print final report
        System.out.println("Scan Results for words of length " + targetLength + ":");
        for (Map.Entry<String, List<Integer>> entry : wordToLines.entrySet()) {
            String word = entry.getKey();
            List<Integer> lines = entry.getValue();
            System.out.println("Word: '" + word + "' | Found on lines: " + lines + " | Processed case: '" + flipCase(word) + "'");
        }
    }
}