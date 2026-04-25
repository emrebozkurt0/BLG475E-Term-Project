package codex.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval158Test {

    @ParameterizedTest(name = "findMax case {index}")
    @MethodSource("findMaxCases")
    public void findMax_returnsExpectedWord(List<String> words, String expected) {
        HumanEval158 solution = new HumanEval158();
        assertEquals(expected, solution.findMax(words));
    }

    private static Stream<Arguments> findMaxCases() {
        return Stream.of(
                Arguments.of(Arrays.asList("name", "of", "string"), "string"),
                Arguments.of(Arrays.asList("name", "enam", "game"), "enam"),
                Arguments.of(Arrays.asList("aaaaaaa", "bb", "cc"), "aaaaaaa"),
                Arguments.of(Arrays.asList("abc", "cba"), "abc"),
                Arguments.of(Arrays.asList("play", "this", "game", "of", "footbott"), "footbott"),
                Arguments.of(Arrays.asList("we", "are", "gonna", "rock"), "gonna"),
                Arguments.of(Arrays.asList("we", "are", "a", "mad", "nation"), "nation"),
                Arguments.of(Arrays.asList("this", "is", "a", "prrk"), "this"),
                Arguments.of(Arrays.asList("b"), "b"),
                Arguments.of(Arrays.asList("play", "play", "play"), "play"),
                Arguments.of(Arrays.asList("aaaa", "abcd", "ab"), "abcd"),
                Arguments.of(Arrays.asList("ba", "ab"), "ab"),
                Arguments.of(List.of("solo"), "solo")
        );
    }

    @ParameterizedTest(name = "findMax invalid case {index}")
    @MethodSource("invalidFindMaxCases")
    public void findMax_invalidInput_throwsExpectedException(List<String> words, Class<? extends Throwable> expectedException) {
        HumanEval158 solution = new HumanEval158();
        assertThrows(expectedException, () -> solution.findMax(words));
    }

    private static Stream<Arguments> invalidFindMaxCases() {
        return Stream.of(
                // Mutation tests for uncovered ECs: EC6 (empty list)
                Arguments.of(List.of(), IndexOutOfBoundsException.class),
                // Mutation tests for uncovered ECs: EC6 (null list)
                Arguments.of(null, NullPointerException.class),
                // Mutation tests for uncovered ECs: EC7 (null element)
                Arguments.of(Arrays.asList("abc", null), NullPointerException.class)
        );
    }
}
