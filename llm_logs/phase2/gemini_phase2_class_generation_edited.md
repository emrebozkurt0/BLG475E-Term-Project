/* @Authors
* Student Names: Mustafa Berkay Arslan, Emre Bozkurt, Harun Yahya Demirpençe
* Student IDs: 150210023, 150210030, 150210022
*/

# LLM Interaction Log: BookScan Class Generation — Edited & Combined Prompt (Gemini - Phase 2)

**Step:** Class Generation (Integration Extension)
**Agent Used:** Gemini
**Dataset:** HumanEval Java — combined #18 (substring), #23 (string length), #27 (upper-lower case) → `BookScan`
**Prompt Variant:** Edited & Combined (improved by us)

### 1. Prompt Sent to Agent
You are an expert Java developer. Generate a complete, compilable Java class named BookScan that analyzes multi-line text and reports word-length statistics. Use only `java.util.*` and `java.lang.*`.

The class must implement three helper methods exactly as specified, plus two public methods that combine them:
- `public int strlen(String)` — string length.
- `public int howManyTimes(String, String)` — overlapping substring count (empty substring → 0).
- `public String flipCase(String)` — flip case per character.
- `public Map<String, List<Integer>> scan(String text, int wordLength)` — split on `\n` (1-based lines), split words on `[\s\p{Punct}]+`, qualify words whose `strlen` equals `wordLength`, match **case-insensitively** (key = first-seen casing), record 1-based line numbers (a word k times on a line → its line number k times via `howManyTimes`). Edge cases: null/empty text → empty map; `wordLength <= 0` → `IllegalArgumentException("wordLength must be positive")`.
- `public int totalOccurrences(String text, int wordLength)` — sum of all list sizes from `scan`.

Constraints: use `strlen`/`howManyTimes`/`flipCase` internally, brief Javadoc on each public method, output a single `.java` file with no markdown fences. A worked example (`"Cat sat on a mat\ncat ran fast\nCAT cat dog"`, length 3) was provided.

### 2. Agent Response
*(Gemini returned a complete class with the three helpers and the full `scan` / `totalOccurrences` public API. Representative snippet:)*

```java
public class BookScan {
    // public int strlen(String) / int howManyTimes(String,String) / String flipCase(String) ...

    public Map<String, List<Integer>> scan(String text, int wordLength) {
        if (text == null || text.isEmpty()) return new LinkedHashMap<>();
        if (wordLength <= 0) throw new IllegalArgumentException("wordLength must be positive");
        // splits on "\n"; words on [\s\p{Punct}]+; groups case-insensitively under first-seen casing;
        // uses strlen/howManyTimes/flipCase; returns word -> list of 1-based line numbers
        ...
    }

    public int totalOccurrences(String text, int wordLength) { /* sum of scan() list sizes */ }
}
// ... full class in the repository
```

### 3. Usage Note
- **Action Taken:** Extracted the `BookScan` class as the edited-prompt output.
- **Modifications:** None to the logic; package declaration `package bookscan.edited.gemini;` already present.
- **Destination:** `src/main/java/bookscan/edited/gemini/BookScan.java`
- **Verification:** Compiles and reproduces the spec's worked example `{Cat=[1,2,3,3], sat=[1], mat=[1], ran=[2], dog=[3]}`. Note: the prompt's example text stated `totalOccurrences = 7`, but the listed map sums to **8**; the generated code correctly returns **8** — the discrepancy is a typo in the prompt, not a code error.
