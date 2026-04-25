package codex.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
                Arguments.of(Arrays.asList("(", ""), "No"),
                // Mutation tests for uncovered ECs: EC6 (non-parenthesis characters)
                Arguments.of(Arrays.asList("abc", "def"), "No")
        );
    }

    @ParameterizedTest(name = "matchParens invalid case {index}")
    @MethodSource("invalidMatchParensCases")
    public void matchParens_invalidInput_throwsExpectedException(List<String> parts, Class<? extends Throwable> expectedException) {
        HumanEval119 solution = new HumanEval119();
        assertThrows(expectedException, () -> solution.matchParens(parts));
    }

    private static Stream<Arguments> invalidMatchParensCases() {
        return Stream.of(
                // Mutation tests for uncovered ECs: EC6 (list size != 2)
                Arguments.of(List.of("()"), IndexOutOfBoundsException.class),
                // Mutation tests for uncovered ECs: EC6 (null list)
                Arguments.of(null, NullPointerException.class)
        );
    }
}
