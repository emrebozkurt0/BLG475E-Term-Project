/* @Authors
* Student Names: Mustafa Berkay Arslan, Emre Bozkurt, Harun Yahya Demirpençe
* Student IDs: 150210023, 150210030, 150210022
*/

# LLM Interaction Log: BookScan Class Generation — Unmodified & Combined Prompt (Codex - Phase 2)

**Step:** Class Generation (Integration Extension)
**Agent Used:** Codex
**Dataset:** HumanEval Java — combined #18 (substring), #23 (string length), #27 (upper-lower case) → `BookScan`
**Prompt Variant:** Unmodified & Combined (baseline)

### 1. Prompt Sent to Agent
Below are three Java programming problems from the HumanEval-Java dataset. Combine them into a single Java class called BookScan. The class should determine how many times words of a given length appear in a text and in which lines they appear, using the three methods.

*(The three raw dataset stubs — `howManyTimes`, `strlen`, `flipCase` — were pasted unchanged, with no added specification.)*

**Clarifying exchange (kept to preserve the unmodified nature):**
> **Codex:** Do you want a specific public API beyond the three methods (e.g., `scan(...)` or `scanAndDisplayStats(...)`)? If yes, name it and the expected signature.
> **Us:** No — there is no required public API beyond the three methods. Implement the class based solely on the task description, adding whatever public method(s) you judge appropriate, using `strlen`, `howManyTimes`, and `flipCase`. Use your own design judgment; we won't prescribe a signature.

### 2. Agent Response
*(Without being given a signature, Codex chose a clean, returnable API. Representative snippet:)*

```java
public class BookScan {
    // public int strlen(String) / int howManyTimes(String,String) / String flipCase(String) ...

    public Map<String, List<Integer>> scan(String text, int wordLength) {
        if (text == null || text.isEmpty()) return new LinkedHashMap<>();
        if (wordLength <= 0) throw new IllegalArgumentException("wordLength must be positive");
        // splits lines on "\n"; tokenizes on [^\p{L}\p{Nd}]+ (Unicode-aware);
        // groups case-insensitively under first-seen casing via flipCase(...).toLowerCase();
        // counts whole-word per-line occurrences with howManyTimes on a space-padded line
        ...
    }
    public int totalOccurrences(String text, int wordLength) { /* sum of scan() list sizes */ }
}
// ... full class in the repository
```

### 3. Usage Note
- **Action Taken:** Extracted the `BookScan` class as the unmodified baseline for the prompt comparison.
- **Modifications:** None. Package declaration `package bookscan.unmodified.codex;` already present.
- **Destination:** `src/main/java/bookscan/unmodified/codex/BookScan.java`
- **Verification:** Compiles. Behavioral observation (key cross-model finding): from the *same* vague prompt, Codex produced a robust, testable design — `scan`/`totalOccurrences`, `LinkedHashMap`, case-insensitive first-seen-casing grouping, `IllegalArgumentException`, and Unicode-aware tokenization — i.e., essentially the design our *edited* prompt had to elicit from Gemini. This is the opposite of Gemini's unmodified output (`void scanAndDisplayStats`), so for Codex the unmodified and edited arms nearly converge. Codex also asked a clarifying question before generating, whereas Gemini assumed a design unprompted.
