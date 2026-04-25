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

    @org.junit.jupiter.api.Test
    public void matchParens_mutation_malformedList_throwsException() {
        // Mutation tests for uncovered ECs: EC6 (list size != 2)
        HumanEval119 solution = new HumanEval119();
        assertThrows(IndexOutOfBoundsException.class, () -> solution.matchParens(List.of("()")));
    }

    @org.junit.jupiter.api.Test
    public void matchParens_mutation_nullList_throwsException() {
        // Mutation tests for uncovered ECs: EC6 (null list)
        HumanEval119 solution = new HumanEval119();
        assertThrows(NullPointerException.class, () -> solution.matchParens(null));
    }
}
