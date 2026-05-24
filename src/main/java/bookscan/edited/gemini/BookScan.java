/* @Authors
* Student Names: Mustafa Berkay Arslan, Emre Bozkurt, Harun Yahya Demirpençe
* Student IDs: 150210023, 150210030, 150210022
*/
package bookscan.edited.gemini;

import java.util.*;

/**
 * BookScan analyzes multi-line text and reports word-length statistics.
 */
public class BookScan {

    /**
     * Returns the length of the given string.
     */
    public int strlen(String string) {
        if (string == null) return 0;
        return string.length();
    }

    /**
     * Returns how many times substring occurs in string, counting overlapping occurrences.
     */
    public int howManyTimes(String string, String substring) {
        if (substring == null || substring.isEmpty()) return 0;
        if (string == null || string.isEmpty()) return 0;
        
        int count = 0;
        int idx = 0;
        while ((idx = string.indexOf(substring, idx)) != -1) {
            count++;
            idx++;
        }
        return count;
    }

    /**
     * Returns a new string where each lowercase letter becomes uppercase and vice versa.
     */
    public String flipCase(String string) {
        if (string == null) return "";
        StringBuilder sb = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Scans text for words matching the given word length.
     */
    public Map<String, List<Integer>> scan(String text, int wordLength) {
        if (text == null || text.isEmpty()) {
            return new LinkedHashMap<>();
        }
        if (wordLength <= 0) {
            throw new IllegalArgumentException("wordLength must be positive");
        }

        Map<String, List<Integer>> result = new LinkedHashMap<>();
        Map<String, String> firstSeenCase = new LinkedHashMap<>();

        String[] lines = text.split("\n", -1);
        int lineNum = 1;

        for (String line : lines) {
            if (line.isEmpty()) {
                lineNum++;
                continue;
            }

            String[] words = line.split("[\\s\\p{Punct}]+");
            String lineUpper = flipCase(line.toLowerCase());
            Set<String> processedWordsLowerInLine = new HashSet<>();

            for (String splitWord : words) {
                if (splitWord.isEmpty()) continue;
                
                if (strlen(splitWord) == wordLength) {
                    String lowerSplitWord = splitWord.toLowerCase();
                    
                    if (!processedWordsLowerInLine.contains(lowerSplitWord)) {
                        processedWordsLowerInLine.add(lowerSplitWord);
                        
                        String upperWord = flipCase(lowerSplitWord);
                        int occurrences = howManyTimes(lineUpper, upperWord);
                        
                        String firstSeen = firstSeenCase.get(lowerSplitWord);
                        if (firstSeen == null) {
                            firstSeen = splitWord;
                            firstSeenCase.put(lowerSplitWord, firstSeen);
                        }
                        
                        List<Integer> lineList = result.computeIfAbsent(firstSeen, k -> new ArrayList<>());
                        for (int i = 0; i < occurrences; i++) {
                            lineList.add(lineNum);
                        }
                    }
                }
            }
            lineNum++;
        }

        return result;
    }

    /**
     * Returns the total amount of occurrences found in a text for a given word length.
     */
    public int totalOccurrences(String text, int wordLength) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        Map<String, List<Integer>> map = scan(text, wordLength);
        int total = 0;
        for (List<Integer> list : map.values()) {
            total += list.size();
        }
        return total;
    }
}
