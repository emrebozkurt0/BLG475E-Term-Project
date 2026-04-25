package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval158Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideFindMaxData() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("name", "enam", "game"), "enam"),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("abc", "cba"), "abc"),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("name", "of", "string"), "string"),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("aaaaaaa", "bb", "cc"), "aaaaaaa"),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("play", "this", "game", "of", "footbott"), "footbott"),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("we", "are", "gonna", "rock"), "gonna"),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("we", "are", "a", "mad", "nation"), "nation"),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("this", "is", "a", "prrk"), "this"),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("b"), "b"),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("play", "play", "play"), "play"),
            // Mutation tests for uncovered ECs: EC2 (tie lexicographic)
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("ba", "ab"), "ab")
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideFindMaxData")
    public void testFindMax(java.util.List<String> input, String expected) {
        HumanEval158 s = new HumanEval158();
        assertEquals(expected, s.findMax(input), "findMax failed for the given input");
    }

    @Test
    public void testFindMaxMutationEmptyList() {
        // Mutation tests for uncovered ECs: EC6 (empty list)
        HumanEval158 s = new HumanEval158();
        assertThrows(IndexOutOfBoundsException.class, () -> s.findMax(java.util.List.of()));
    }

    @Test
    public void testFindMaxMutationNullList() {
        // Mutation tests for uncovered ECs: EC6 (null list)
        HumanEval158 s = new HumanEval158();
        assertThrows(NullPointerException.class, () -> s.findMax(null));
    }

    @Test
    public void testFindMaxMutationNullElement() {
        // Mutation tests for uncovered ECs: EC7 (null element)
        HumanEval158 s = new HumanEval158();
        assertThrows(NullPointerException.class, () -> s.findMax(Arrays.asList("abc", null)));
    }
}
