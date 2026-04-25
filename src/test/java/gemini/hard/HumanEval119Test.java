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

public class HumanEval119Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideParensData() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("()(", ")"), "Yes", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(")())", "(()()("), "Yes", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("(())))", "(()())(("), "Yes", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("(()(", "()))()"), "Yes", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(")", ")"), "No", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("(()(())", "())())"), "No", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("()", "())"), "No", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("((((", "((())"), "No", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(")(()", "(()("), "No", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(")(", ")("), "No", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("a", "b"), "Yes", null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("", ""), "Yes", null),
            org.junit.jupiter.params.provider.Arguments.of(List.of("()"), null, IndexOutOfBoundsException.class),
            org.junit.jupiter.params.provider.Arguments.of(null, null, NullPointerException.class)
        );
    }

    private void executeMatchParensAssertion(HumanEval119 s, List<String> input, String expected, Class<? extends Throwable> expectedException) {
        if (expectedException != null) {
            assertThrows(expectedException, () -> s.matchParens(input));
        } else {
            assertEquals(expected, s.matchParens(input), "matchParens output should match expected");
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideParensData")
    public void testMatchParens(List<String> input, String expected, Class<? extends Throwable> expectedException) {
        HumanEval119 s = new HumanEval119();
        org.junit.jupiter.api.Assertions.assertNotNull(s);
        executeMatchParensAssertion(s, input, expected, expectedException);
    }
}
