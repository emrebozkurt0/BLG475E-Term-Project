/* @Authors
* Student Names: Mustafa Berkay Arslan, Emre Bozkurt, Harun Yahya Demirpençe
* Student IDs: 150210023, 150210030, 150210022
*/
package bookscan.edited.gemini;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BookScanIntegrationTest {
    private BookScan bookScan;

    @BeforeEach
    void setUp() {
        bookScan = new BookScan();
    }

    @Test
    void scanAndTotal_emptyText_returnsEmptyMapAndZeroCount() {
        Map<String, List<Integer>> result = bookScan.scan("", 5);
        assertTrue(result.isEmpty(), "Expected empty map for empty text");

        int total = bookScan.totalOccurrences("", 5);
        assertEquals(0, total, "Expected zero total occurrences for empty text");
    }

    @Test
    void scanAndTotal_nullText_returnsEmptyMapAndZeroCount() {
        Map<String, List<Integer>> result = bookScan.scan(null, 5);
        assertTrue(result.isEmpty(), "Expected empty map for null text");

        int total = bookScan.totalOccurrences(null, 5);
        assertEquals(0, total, "Expected zero total occurrences for null text");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -50})
    void scanAndTotal_wordLengthZeroOrNegative_throwsIllegalArgumentException(int length) {
        assertThrows(IllegalArgumentException.class, () -> bookScan.scan("hello world", length),
                "Expected scan() to throw IllegalArgumentException for non-positive word length");

        assertThrows(IllegalArgumentException.class, () -> bookScan.totalOccurrences("hello world", length),
                "Expected totalOccurrences() to throw IllegalArgumentException for non-positive word length");
    }

    @Test
    void scan_singleLineSingleQualifyingWord_returnsCorrectMap() {
        String text = "The quick brown fox jumps";
        Map<String, List<Integer>> result = bookScan.scan(text, 5);
        
        assertEquals(3, result.size(), "Should find 'quick', 'brown', and 'jumps'");
        assertTrue(result.containsKey("quick"));
        assertTrue(result.containsKey("brown"));
        assertTrue(result.containsKey("jumps"));
        assertEquals(List.of(1), result.get("quick"));
        assertEquals(List.of(1), result.get("brown"));
        assertEquals(List.of(1), result.get("jumps"));
    }

    @Test
    void scan_multipleLinesRepeatedWordAcrossLines_groupsCorrectlyAndTracksLines() {
        String text = "Apple is red\nBanana is yellow\napple is sweet";
        Map<String, List<Integer>> result = bookScan.scan(text, 5);

        assertEquals(2, result.size(), "Should find 'Apple' and 'sweet'");
        assertTrue(result.containsKey("Apple"));
        assertTrue(result.containsKey("sweet"));
        assertEquals(List.of(1, 3), result.get("Apple"));
        assertEquals(List.of(3), result.get("sweet"));
    }

    @Test
    void scan_repeatedWordMultipleTimesOnSameLine_repeatsLineNumber() {
        String text = "test this test, and test again";
        Map<String, List<Integer>> result = bookScan.scan(text, 4);

        assertEquals(2, result.size(), "Should find 'test' and 'this'");
        assertTrue(result.containsKey("test"));
        assertTrue(result.containsKey("this"));
        assertEquals(List.of(1, 1, 1), result.get("test")); 
        assertEquals(List.of(1), result.get("this"));
    }

    @ParameterizedTest
    @CsvSource({
            "'Cat jumped over this cAT then this cat purred', 3, 'Cat', 3",
            "'cAT cat CaT', 3, 'cAT', 3",
            "'DOG dog', 3, 'DOG', 2"
    })
    void scan_caseInsensitiveMatching_groupsUnderFirstSeenCasing(String text, int length, String expectedKey, int expectedOccurrences) {
        Map<String, List<Integer>> result = bookScan.scan(text, length);
        
        assertEquals(1, result.size());
        assertTrue(result.containsKey(expectedKey), "Expected to group all casings under the first seen casing: " + expectedKey);
        assertEquals(expectedOccurrences, result.get(expectedKey).size());
    }

    @Test
    void scan_punctuationAsDelimiter_countsWordsProperly() {
        String text = "hello, world! this-is...hello";
        Map<String, List<Integer>> result = bookScan.scan(text, 5);

        assertEquals(2, result.size());
        assertTrue(result.containsKey("hello"));
        assertTrue(result.containsKey("world"));
        assertEquals(List.of(1, 1), result.get("hello"));
        assertEquals(List.of(1), result.get("world"));
    }

    @Test
    void scan_mixedWhitespace_handlesTabsAndNewlinesCorrectly() {
        String text = "one\t\t\ttwo   three\n\n\tfour    one";
        Map<String, List<Integer>> result = bookScan.scan(text, 3);

        assertEquals(2, result.size());
        assertTrue(result.containsKey("one"));
        assertTrue(result.containsKey("two"));
        assertEquals(List.of(1, 3), result.get("one")); 
        assertEquals(List.of(1), result.get("two"));   
    }

    @Test
    void scanAndTotal_wordLengthLargerThanAnyWord_returnsEmptyMapAndZeroTotal() {
        String text = "short text here";
        Map<String, List<Integer>> result = bookScan.scan(text, 20);
        assertTrue(result.isEmpty(), "Expected empty map for wordLength exceeding max word size");

        int total = bookScan.totalOccurrences(text, 20);
        assertEquals(0, total, "Expected zero total for wordLength exceeding max word size");
    }

    @Test
    void scan_unicodeNonAsciiLetters_handlesProperly() {
        String text = "café, caFÉ!"; // basic unicode assumption test
        Map<String, List<Integer>> result = bookScan.scan(text, 4);
        
        assertTrue(result.containsKey("café"));
        assertEquals(List.of(1, 1), result.get("café")); 
        assertEquals(1, result.size());
    }

    @Test
    void totalOccurrences_internalConsistency_matchesSumOfMapSizes() {
        String text = "Integration testing is crucial. Testing testing. Is it crucial? Yes, crucial it is.";
        int wordLength = 7; 
        
        Map<String, List<Integer>> map = bookScan.scan(text, wordLength);
        int totalOccurrences = bookScan.totalOccurrences(text, wordLength);

        int sumFromMap = 0;
        for (List<Integer> lines : map.values()) {
            sumFromMap += lines.size();
        }

        assertEquals(sumFromMap, totalOccurrences, "Total occurrences should equal the sum of list sizes from scan()");
        assertEquals(6, totalOccurrences, "Expected exactly 6 total qualifying instances ('testing'x3, 'crucial'x3)");
    }
}