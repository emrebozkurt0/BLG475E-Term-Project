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

        @ParameterizedTest(name = "doAlgebra invalid case {index}")
        @MethodSource("invalidDoAlgebraCases")
        public void doAlgebra_invalidInput_throwsExpectedException(
            List<String> operators,
            List<Integer> operands,
            Class<? extends Throwable> expectedException
        ) {
        HumanEval160 solution = new HumanEval160();
        assertThrows(expectedException,
            () -> solution.doAlgebra(new ArrayList<>(operators), new ArrayList<>(operands)));
        }

        private static Stream<Arguments> invalidDoAlgebraCases() {
        return Stream.of(
            // Mutation tests for uncovered ECs: EC8 (operator/operand size mismatch)
            Arguments.of(ops("+", "+"), nums(1, 2), IndexOutOfBoundsException.class),
            // Mutation tests for uncovered ECs: EC9 (division by zero)
            Arguments.of(ops("/"), nums(3, 0), ArithmeticException.class)
        );
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
