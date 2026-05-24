/* @Authors
* Student Names: Mustafa Berkay Arslan, Emre Bozkurt, Harun Yahya Demirpençe
* Student IDs: 150210023, 150210030, 150210022
*/

# LLM Interaction Log: BookScan Class Generation — Unmodified & Combined Prompt (Gemini - Phase 2)

**Step:** Class Generation (Integration Extension)
**Agent Used:** Gemini
**Dataset:** HumanEval Java — combined #18 (substring), #23 (string length), #27 (upper-lower case) → `BookScan`
**Prompt Variant:** Unmodified & Combined (baseline)

### 1. Prompt Sent to Agent
Below are three Java programming problems from the HumanEval-Java dataset. Combine them into a single Java class called BookScan. The class should determine how many times words of a given length appear in a text and in which lines they appear, using the three methods.

*(The three raw dataset stubs were pasted unchanged, with no added specification:)*
- **Problem 1 — `public int howManyTimes(String string, String substring)`** — count overlapping occurrences of a substring.
- **Problem 2 — `public int strlen(String string)`** — return the length of a string.
- **Problem 3 — `public String flipCase(String string)`** — flip lowercase ↔ uppercase.

### 2. Agent Response
*(Gemini returned the three helpers plus a single combining method. Because the prompt left the API undefined, it produced a `void` method that prints to `System.out` instead of a returnable API. Representative snippet:)*

```java
public class BookScan {
    // public int strlen(String) / int howManyTimes(String,String) / String flipCase(String) ...

    public void scanAndDisplayStats(List<String> textLines, int targetLength) {
        Map<String, List<Integer>> wordToLines = new HashMap<>();
        for (int i = 0; i < textLines.size(); i++) {
            String[] words = textLines.get(i).split("\\s+");      // whitespace only
            for (String word : words) {
                if (strlen(word) == targetLength) {
                    wordToLines.computeIfAbsent(word, k -> new ArrayList<>()).add(i + 1);
                }
            }
        }
        System.out.println("Scan Results for words of length " + targetLength + ":");
        // prints: Word: '<word>' | Found on lines: <lines> | Processed case: '<flipCase(word)>'
    }
}
// ... full class in the repository
```

### 3. Usage Note
- **Action Taken:** Extracted the `BookScan` class and kept it as the unmodified baseline for the prompt comparison.
- **Modifications:** Algorithm left unchanged. Only `package bookscan.unmodified.gemini;` was added so the file compiles inside the repository (non-algorithmic housekeeping).
- **Destination:** `src/main/java/bookscan/unmodified/gemini/BookScan.java`
- **Verification:** Compiles. The vague prompt produced a `void`, console-printing `scanAndDisplayStats(List<String>, int)` rather than a returnable API — no `scan`/`totalOccurrences`, `HashMap` (no ordering / first-seen casing), case-sensitive matching, whitespace-only splitting (no punctuation), and no input validation. These deficiencies are intentionally preserved as the baseline against the edited-prompt output.
