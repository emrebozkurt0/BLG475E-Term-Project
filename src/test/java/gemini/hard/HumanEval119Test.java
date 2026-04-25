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
            org.junit.jupiter.params.provider.Arguments.of(new String[]{"()(", ")"}, "Yes"),
            org.junit.jupiter.params.provider.Arguments.of(new String[]{")())", "(()()("}, "Yes"),
            org.junit.jupiter.params.provider.Arguments.of(new String[]{"(())))", "(()())(("}, "Yes"),
            org.junit.jupiter.params.provider.Arguments.of(new String[]{"(()(", "()))()"}, "Yes"),
            org.junit.jupiter.params.provider.Arguments.of(new String[]{")", ")"}, "No"),
            org.junit.jupiter.params.provider.Arguments.of(new String[]{"(()(())", "())())"}, "No"),
            org.junit.jupiter.params.provider.Arguments.of(new String[]{"()", "())"}, "No"),
            org.junit.jupiter.params.provider.Arguments.of(new String[]{"((((", "((())"}, "No"),
            org.junit.jupiter.params.provider.Arguments.of(new String[]{")(()", "(()("}, "No"),
            org.junit.jupiter.params.provider.Arguments.of(new String[]{")(", ")("}, "No"),
            org.junit.jupiter.params.provider.Arguments.of(new String[]{"a", "b"}, "Yes"),
            // Mutation tests for uncovered ECs: EC5 (both empty)
            org.junit.jupiter.params.provider.Arguments.of(new String[]{"", ""}, "Yes")
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideParensData")
    public void testMatchParens(String[] input, String expected) {
        HumanEval119 s = new HumanEval119();
        assertEquals(expected, s.matchParens(Arrays.asList(input)), "matchParens output should match expected");
    }

    static Stream<Arguments> provideInvalidParensData() {
        return Stream.of(
            // Mutation tests for uncovered ECs: EC6 (list size != 2)
            Arguments.of(List.of("()"), IndexOutOfBoundsException.class),
            // Mutation tests for uncovered ECs: EC6 (null list)
            Arguments.of(null, NullPointerException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidParensData")
    public void testMatchParensInvalidInputs(List<String> input, Class<? extends Throwable> expectedException) {
        HumanEval119 s = new HumanEval119();
        assertThrows(expectedException, () -> s.matchParens(input));
    }
}
