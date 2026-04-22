package codex.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval119Test {

    @ParameterizedTest(name = "matchParens case {index}")
    @MethodSource("matchParensCases")
    public void matchParens_returnsExpectedResult(List<String> parts, String expected) {
        HumanEval119 solution = new HumanEval119();
        assertEquals(expected, solution.matchParens(parts));
    }

    private static Stream<Arguments> matchParensCases() {
        return Stream.of(
                Arguments.of(Arrays.asList("()(", ")"), "Yes"),
                Arguments.of(Arrays.asList("(()(", "()))()"), "Yes"),
                Arguments.of(Arrays.asList(")())", "(()()("), "Yes"),
                Arguments.of(Arrays.asList("(())))", "(()())(("), "Yes"),
                Arguments.of(Arrays.asList(")", ")"), "No"),
                Arguments.of(Arrays.asList("(()(())", "())())"), "No"),
                Arguments.of(Arrays.asList("()", "())"), "No"),
                Arguments.of(Arrays.asList("(((", "((())"), "No"),
                Arguments.of(Arrays.asList(")(()", "(()("), "No"),
                Arguments.of(Arrays.asList(")(", ")("), "No"),
                Arguments.of(Arrays.asList("", ""), "Yes"),
                Arguments.of(Arrays.asList("(", ""), "No")
        );
    }
}
