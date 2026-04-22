package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("play", "play", "play"), "play")
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideFindMaxData")
    public void testFindMax(java.util.List<String> input, String expected) {
        HumanEval158 s = new HumanEval158();
        assertEquals(expected, s.findMax(input), "findMax failed for the given input");
    }
}
