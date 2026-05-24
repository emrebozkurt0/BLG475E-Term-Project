package bookscan.unmodified.codex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BookScanIntegrationTest {

    private final BookScan scanner = new BookScan();

    @Test
    void emptyTextReturnsEmptyMapAndZeroTotal() {
        Map<String, List<Integer>> result = scanner.scan("", 3);
        assertTrue(result.isEmpty());
        assertEquals(0, scanner.totalOccurrences("", 3));
    }

    @Test
    void nullTextReturnsEmptyMapAndZeroTotal() {
        Map<String, List<Integer>> result = scanner.scan(null, 3);
        assertTrue(result.isEmpty());
        assertEquals(0, scanner.totalOccurrences(null, 3));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void scanThrowsWhenWordLengthIsNonPositive(int wordLength) {
        assertThrows(IllegalArgumentException.class, () -> scanner.scan("a bb", wordLength));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -2})
    void totalOccurrencesThrowsWhenWordLengthIsNonPositive(int wordLength) {
        assertThrows(IllegalArgumentException.class, () -> scanner.totalOccurrences("a bb", wordLength));
    }

    @Test
    void singleLineSingleQualifyingWord() {
        Map<String, List<Integer>> result = scanner.scan("hi world", 2);
        assertEquals(1, result.size());
        assertEquals(List.of(1), result.get("hi"));
        assertEquals(1, scanner.totalOccurrences("hi world", 2));
    }

    @Test
    void multipleLinesRepeatedWordAcrossLines() {
        String text = "cat dog\nbird cat";
        Map<String, List<Integer>> result = scanner.scan(text, 3);
        assertEquals(List.of(1, 2), result.get("cat"));
        assertEquals(List.of(1), result.get("dog"));
        assertEquals(3, scanner.totalOccurrences(text, 3));
    }

    @Test
    void repeatedWordMultipleTimesOnSameLineRepeatsLineNumber() {
        String text = "cat cat cat";
        Map<String, List<Integer>> result = scanner.scan(text, 3);
        assertEquals(Arrays.asList(1, 1, 1), result.get("cat"));
        assertEquals(3, scanner.totalOccurrences(text, 3));
    }

    @ParameterizedTest
    @MethodSource("caseInsensitiveInputs")
    void caseInsensitiveGroupingPreservesFirstSeenCasing(String text, String expectedKey) {
        Map<String, List<Integer>> result = scanner.scan(text, 3);
        assertEquals(1, result.size());
        assertTrue(result.containsKey(expectedKey));
        assertEquals(Arrays.asList(1, 1, 1), result.get(expectedKey));
        assertEquals(3, scanner.totalOccurrences(text, 3));
    }

    @Test
    void punctuationActsAsDelimiter() {
        String text = "hello, world!";
        Map<String, List<Integer>> result = scanner.scan(text, 5);
        assertEquals(List.of(1), result.get("hello"));
        assertEquals(List.of(1), result.get("world"));
        assertEquals(2, scanner.totalOccurrences(text, 5));
    }

    @Test
    void mixedWhitespaceActsAsDelimiter() {
        String text = "one\t  two   three";
        Map<String, List<Integer>> result = scanner.scan(text, 3);
        assertEquals(List.of(1), result.get("one"));
        assertEquals(List.of(1), result.get("two"));
        assertEquals(2, scanner.totalOccurrences(text, 3));
    }

    @Test
    void wordLengthLargerThanAnyWordReturnsEmptyResults() {
        String text = "a bb ccc";
        Map<String, List<Integer>> result = scanner.scan(text, 10);
        assertTrue(result.isEmpty());
        assertEquals(0, scanner.totalOccurrences(text, 10));
    }

    @Test
    void unicodeLettersAreHandledCaseInsensitively() {
        String text = "caf\u00e9 CAF\u00c9";
        Map<String, List<Integer>> result = scanner.scan(text, 4);
        assertEquals(1, result.size());
        assertTrue(result.containsKey("caf\u00e9"));
        assertEquals(Arrays.asList(1, 1), result.get("caf\u00e9"));
        assertEquals(2, scanner.totalOccurrences(text, 4));
    }

    @Test
    void totalOccurrencesMatchesSumOfScanCounts() {
        String text = "alpha beta\nbeta alpha alpha";
        Map<String, List<Integer>> result = scanner.scan(text, 5);
        int sum = 0;
        for (List<Integer> lines : result.values()) {
            sum += lines.size();
        }
        assertEquals(sum, scanner.totalOccurrences(text, 5));
    }

    private static Stream<Arguments> caseInsensitiveInputs() {
        return Stream.of(
                Arguments.of("Cat cat CAT", "Cat"),
                Arguments.of("cat CAT Cat", "cat"),
                Arguments.of("CAT cat Cat", "CAT")
        );
    }
}
