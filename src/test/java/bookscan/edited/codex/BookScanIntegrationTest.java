/* @Authors
* Student Names: Mustafa Berkay Arslan, Emre Bozkurt, Harun Yahya Demirpençe
* Student IDs: 150210023, 150210030, 150210022
*/
package bookscan.edited.codex;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BookScanIntegrationTest {

    @Test
    void emptyTextReturnsEmptyMapAndZeroTotal() {
        BookScan bookScan = new BookScan();

        Map<String, List<Integer>> result = bookScan.scan("", 3);

        assertTrue(result.isEmpty());
        assertEquals(0, bookScan.totalOccurrences("", 3));
    }

    @Test
    void nullTextReturnsEmptyMapAndZeroTotal() {
        BookScan bookScan = new BookScan();

        Map<String, List<Integer>> result = bookScan.scan(null, 3);

        assertTrue(result.isEmpty());
        assertEquals(0, bookScan.totalOccurrences(null, 3));
    }

    @Test
    void nonPositiveWordLengthThrowsForScanAndTotalOccurrences() {
        BookScan bookScan = new BookScan();

        assertThrows(IllegalArgumentException.class, () -> bookScan.scan("text", 0));
        assertThrows(IllegalArgumentException.class, () -> bookScan.scan("text", -2));
        assertThrows(IllegalArgumentException.class, () -> bookScan.totalOccurrences("text", 0));
        assertThrows(IllegalArgumentException.class, () -> bookScan.totalOccurrences("text", -2));
    }

    @Test
    void singleLineSingleQualifyingWordIsCounted() {
        BookScan bookScan = new BookScan();

        Map<String, List<Integer>> result = bookScan.scan("alpha beta", 5);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("alpha"));
        assertEquals(List.of(1), result.get("alpha"));
        assertEquals(1, bookScan.totalOccurrences("alpha beta", 5));
    }

    @Test
    void repeatedWordAcrossLinesAccumulatesLineNumbers() {
        BookScan bookScan = new BookScan();

        Map<String, List<Integer>> result = bookScan.scan("echo\nnoise\necho", 4);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("echo"));
        assertEquals(List.of(1, 3), result.get("echo"));
        assertEquals(2, bookScan.totalOccurrences("echo\nnoise\necho", 4));
    }

    @Test
    void repeatedWordSameLineRepeatsLineNumber() {
        BookScan bookScan = new BookScan();

        Map<String, List<Integer>> result = bookScan.scan("echo echo echo", 4);

        assertEquals(1, result.size());
        assertEquals(List.of(1, 1, 1), result.get("echo"));
        assertEquals(3, bookScan.totalOccurrences("echo echo echo", 4));
    }

    @ParameterizedTest
    @CsvSource({
            "Cat cat CAT, Cat",
            "cat CAT Cat, cat",
            "CAT Cat cat, CAT"
    })
    void caseInsensitiveMatchingGroupsUnderFirstSeenCasing(String text, String expectedKey) {
        BookScan bookScan = new BookScan();

        Map<String, List<Integer>> result = bookScan.scan(text, 3);

        assertEquals(1, result.size());
        assertTrue(result.containsKey(expectedKey));
        assertEquals(3, result.get(expectedKey).size());
        assertEquals(3, bookScan.totalOccurrences(text, 3));
    }

    @Test
    void punctuationIsUsedAsDelimiter() {
        BookScan bookScan = new BookScan();

        Map<String, List<Integer>> result = bookScan.scan("hello, world!", 5);

        assertEquals(2, result.size());
        assertEquals(List.of(1), result.get("hello"));
        assertEquals(List.of(1), result.get("world"));
        assertEquals(2, bookScan.totalOccurrences("hello, world!", 5));
    }

    @Test
    void mixedWhitespaceIsHandledAsDelimiter() {
        BookScan bookScan = new BookScan();

        Map<String, List<Integer>> result = bookScan.scan("foo\tbar  baz", 3);

        assertEquals(3, result.size());
        assertEquals(List.of(1), result.get("foo"));
        assertEquals(List.of(1), result.get("bar"));
        assertEquals(List.of(1), result.get("baz"));
        assertEquals(3, bookScan.totalOccurrences("foo\tbar  baz", 3));
    }

    @Test
    void wordLengthLargerThanAnyWordReturnsEmptyResults() {
        BookScan bookScan = new BookScan();

        Map<String, List<Integer>> result = bookScan.scan("tiny words here", 10);

        assertTrue(result.isEmpty());
        assertEquals(0, bookScan.totalOccurrences("tiny words here", 10));
    }

    @Test
    void unicodeLettersAreCountedWhenLengthMatches() {
        BookScan bookScan = new BookScan();

        Map<String, List<Integer>> result = bookScan.scan("café CAFÉ", 4);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("café"));
        assertEquals(List.of(1, 1), result.get("café"));
        assertEquals(2, bookScan.totalOccurrences("café CAFÉ", 4));
    }

    @Test
    void totalOccurrencesMatchesSumOfScanLineCounts() {
        BookScan bookScan = new BookScan();
        String text = "Alpha beta alpha\nBeta, alpha!";

        Map<String, List<Integer>> result = bookScan.scan(text, 5);

        int sum = 0;
        for (List<Integer> lines : result.values()) {
            sum += lines.size();
        }
        assertEquals(sum, bookScan.totalOccurrences(text, 5));
    }
}
