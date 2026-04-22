package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
            org.junit.jupiter.params.provider.Arguments.of(new String[]{"a", "b"}, "Yes")
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideParensData")
    public void testMatchParens(String[] input, String expected) {
        HumanEval119 s = new HumanEval119();
        assertEquals(expected, s.matchParens(Arrays.asList(input)), "matchParens output should match expected");
    }
}
