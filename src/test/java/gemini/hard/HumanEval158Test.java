package gemini.hard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval158Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideFindMaxData() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("name", "enam", "game"), "enam", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("abc", "cba"), "abc", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("name", "of", "string"), "string", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("aaaaaaa", "bb", "cc"), "aaaaaaa", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("play", "this", "game", "of", "footbott"), "footbott", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("we", "are", "gonna", "rock"), "gonna", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("we", "are", "a", "mad", "nation"), "nation", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("this", "is", "a", "prrk"), "this", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("b"), "b", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("play", "play", "play"), "play", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("ba", "ab"), "ab", null),
            org.junit.jupiter.params.provider.Arguments.of(List.of(), null, IndexOutOfBoundsException.class),
            org.junit.jupiter.params.provider.Arguments.of(null, null, NullPointerException.class),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("abc", null), null, NullPointerException.class)
        );
    }

    private void executeFindMaxAssertion(HumanEval158 s, java.util.List<String> input, String expected, Class<? extends Throwable> expectedException) {
        if (expectedException != null) {
            assertThrows(expectedException, () -> s.findMax(input));
        } else {
            assertEquals(expected, s.findMax(input), "findMax failed for the given input");
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideFindMaxData")
    public void testFindMax(java.util.List<String> input, String expected, Class<? extends Throwable> expectedException) {
        HumanEval158 s = new HumanEval158();
        org.junit.jupiter.api.Assertions.assertNotNull(s);
        executeFindMaxAssertion(s, input, expected, expectedException);
    }
}
