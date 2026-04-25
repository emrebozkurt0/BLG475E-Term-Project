package codex.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval160Test {

    @ParameterizedTest(name = "doAlgebra case {index}")
    @MethodSource("doAlgebraCases")
    public void doAlgebra_returnsExpectedValue(List<String> operators, List<Integer> operands, int expected) {
        HumanEval160 solution = new HumanEval160();
        assertEquals(expected, solution.doAlgebra(new ArrayList<>(operators), new ArrayList<>(operands)));
    }

    private static Stream<Arguments> doAlgebraCases() {
        return Stream.of(
                Arguments.of(ops("**", "*", "+"), nums(2, 3, 4, 5), 37),
                Arguments.of(ops("+", "*", "-"), nums(2, 3, 4, 5), 9),
                Arguments.of(ops("/", "*"), nums(7, 3, 4), 8),
                Arguments.of(ops("+", "**", "**"), nums(7, 5, 3, 2), 1953132),
                // Mutation tests for uncovered ECs: EC6 (minimum valid sizes)
                Arguments.of(ops("+"), nums(1, 2), 3),
                Arguments.of(ops(), nums(42), 42),
                Arguments.of(ops("*", "/"), nums(10, 3, 2), 15),
                Arguments.of(ops("-", "+", "-"), nums(10, 3, 2, 5), 4),
                Arguments.of(ops("+", "**"), nums(8, 3, 2), 17),
                Arguments.of(ops("%"), nums(9, 4), 9)
        );
    }

    @org.junit.jupiter.api.Test
    public void doAlgebra_mutation_lengthMismatch_throwsException() {
        // Mutation tests for uncovered ECs: EC8 (operator/operand size mismatch)
        HumanEval160 solution = new HumanEval160();
        assertThrows(IndexOutOfBoundsException.class,
                () -> solution.doAlgebra(new ArrayList<>(ops("+", "+")), new ArrayList<>(nums(1, 2))));
    }

    @org.junit.jupiter.api.Test
    public void doAlgebra_mutation_divisionByZero_throwsException() {
        // Mutation tests for uncovered ECs: EC9 (division by zero)
        HumanEval160 solution = new HumanEval160();
        assertThrows(ArithmeticException.class,
                () -> solution.doAlgebra(new ArrayList<>(ops("/")), new ArrayList<>(nums(3, 0))));
    }

    private static List<String> ops(String... values) {
        return Arrays.asList(values);
    }

    private static List<Integer> nums(int... values) {
        List<Integer> result = new ArrayList<>();
        for (int value : values) {
            result.add(value);
        }
        return result;
    }
}
