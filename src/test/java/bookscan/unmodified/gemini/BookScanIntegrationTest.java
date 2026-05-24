/* @Authors
* Student Names: Mustafa Berkay Arslan, Emre Bozkurt, Harun Yahya Demirpençe
* Student IDs: 150210023, 150210030, 150210022
*/
package bookscan.unmodified.gemini;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookScanIntegrationTest {
    private BookScan bookScan;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        bookScan = new BookScan();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testEmptyListPrintsOnlyHeader() {
        bookScan.scanAndDisplayStats(Collections.emptyList(), 5);
        String output = outContent.toString();
        
        assertTrue(output.contains("Scan Results for words of length 5:"));
        assertFalse(output.contains("Word:"));
    }

    @Test
    void testSingleLineSingleQualifyingWord() {
        // Line 1: "The" (3), "quick" (5), "brown" (5), "fox" (3)
        // Target: 5
        List<String> textLines = List.of("The quick brown fox");
        bookScan.scanAndDisplayStats(textLines, 5);
        String output = outContent.toString();
        
        assertTrue(output.contains("Scan Results for words of length 5:"));
        assertTrue(output.contains("Word: 'quick' | Found on lines: [1] | Processed case: 'QUICK'"));
        assertTrue(output.contains("Word: 'brown' | Found on lines: [1] | Processed case: 'BROWN'"));
    }

    @Test
    void testSameWordRepeatedAcrossMultipleLines() {
        // Line 1: "apple" (5)
        // Line 2: "banana" (6)
        // Line 3: "apple" (5)
        // Line 4: "dog" (3), "apple" (5)
        // Target: 5
        List<String> textLines = List.of("apple", "banana", "apple", "dog apple");
        bookScan.scanAndDisplayStats(textLines, 5);
        String output = outContent.toString();
        
        assertTrue(output.contains("Scan Results for words of length 5:"));
        assertTrue(output.contains("Word: 'apple' | Found on lines: [1, 3, 4] | Processed case: 'APPLE'"));
        assertFalse(output.contains("Word: 'banana'"));
    }

    @Test
    void testSameWordRepeatedMultipleTimesOnOneLine() {
        // Line 1: "test" (4), "test" (4), "test" (4)
        // Line 2: "another" (7), "test" (4)
        // Line 3: "no" (2)
        // Target: 4
        List<String> textLines = List.of("test test test", "another test", "no");
        bookScan.scanAndDisplayStats(textLines, 4);
        String output = outContent.toString();
        
        assertTrue(output.contains("Scan Results for words of length 4:"));
        assertTrue(output.contains("Word: 'test' | Found on lines: [1, 1, 1, 2] | Processed case: 'TEST'"));
    }

    @Test
    void testCaseSensitivityYieldsSeparateEntries() {
        // Line 1: "Cat" (3)
        // Line 2: "cat" (3)
        // Line 3: "CAT" (3)
        // Target: 3
        List<String> textLines = List.of("Cat", "cat", "CAT");
        bookScan.scanAndDisplayStats(textLines, 3);
        String output = outContent.toString();
        
        assertTrue(output.contains("Scan Results for words of length 3:"));
        assertTrue(output.contains("Word: 'Cat' | Found on lines: [1] | Processed case: 'cAT'"));
        assertTrue(output.contains("Word: 'cat' | Found on lines: [2] | Processed case: 'CAT'"));
        assertTrue(output.contains("Word: 'CAT' | Found on lines: [3] | Processed case: 'cat'"));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20})
    void testTargetLengthLargerThanAnyWordPrintsOnlyHeader(int targetLength) {
        // Line 1: "a" (1), "bb" (2), "ccc" (3), "dddd" (4)
        List<String> textLines = List.of("a bb ccc dddd");
        bookScan.scanAndDisplayStats(textLines, targetLength);
        String output = outContent.toString();
        
        assertTrue(output.contains("Scan Results for words of length " + targetLength + ":"));
        assertFalse(output.contains("Word:"));
    }

    @Test
    void testMixedWhitespaceSplitsWordsCorrectly() {
        // Line 1: "word" (4), "word" (4) -> seperated by spaces and tabs
        // Line 2: empty
        // Line 3: "word" (4), "another" (7), "word" (4)
        // Target: 4
        List<String> textLines = new ArrayList<>();
        textLines.add("word   \t  word");
        textLines.add("");
        textLines.add("\t word    another     word");
        
        bookScan.scanAndDisplayStats(textLines, 4);
        String output = outContent.toString();
        
        assertTrue(output.contains("Scan Results for words of length 4:"));
        assertTrue(output.contains("Word: 'word' | Found on lines: [1, 1, 3, 3] | Processed case: 'WORD'"));
    }

    @Test
    void testPunctuationNotStripped() {
        // Line 1: "hello," (6), "world!" (6)
        // Line 2: "test." (5)
        // Target: 6 for hello,/world!, 5 for test.
        List<String> textLines = List.of("hello, world!", "test.");
        
        bookScan.scanAndDisplayStats(textLines, 6);
        String output6 = outContent.toString();
        assertTrue(output6.contains("Word: 'hello,' | Found on lines: [1] | Processed case: 'HELLO,'"));
        assertTrue(output6.contains("Word: 'world!' | Found on lines: [1] | Processed case: 'WORLD!'"));
        
        outContent.reset();
        
        bookScan.scanAndDisplayStats(textLines, 5);
        String output5 = outContent.toString();
        assertTrue(output5.contains("Word: 'test.' | Found on lines: [2] | Processed case: 'TEST.'"));
        assertFalse(output5.contains("hello")); // "hello," is length 6, not 5
    }
}