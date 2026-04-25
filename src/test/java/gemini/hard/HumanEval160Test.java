package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval160Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideAlgebraData() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("**", "*", "+")), new ArrayList<>(Arrays.asList(2, 3, 4, 5)), 37),
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("+", "*", "-")), new ArrayList<>(Arrays.asList(2, 3, 4, 5)), 9),
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("/", "*")), new ArrayList<>(Arrays.asList(7, 3, 4)), 8),
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("+", "**", "**")), new ArrayList<>(Arrays.asList(7, 5, 3, 2)), 1953132),
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("//")), new ArrayList<>(Arrays.asList(7, 3)), 2),
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("?")), new ArrayList<>(Arrays.asList(2, 3)), 2),
            // Mutation tests for uncovered ECs: EC6 (minimum valid sizes)
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("+")), new ArrayList<>(Arrays.asList(1, 2)), 3),
            // Mutation tests for uncovered ECs: EC10 (empty operators with one operand)
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(), new ArrayList<>(Arrays.asList(42)), 42)
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideAlgebraData")
    public void testDoAlgebra(ArrayList<String> ops, ArrayList<Integer> nums, int expected) {
        HumanEval160 s = new HumanEval160();
        assertEquals(expected, s.doAlgebra(ops, nums), "doAlgebra returned incorrect value");
    }

    static Stream<Arguments> provideInvalidAlgebraData() {
        return Stream.of(
            // Mutation tests for uncovered ECs: EC8 (operator/operand size mismatch)
            Arguments.of(Arrays.asList("+", "+"), Arrays.asList(1, 2), IndexOutOfBoundsException.class),
            // Mutation tests for uncovered ECs: EC9 (division by zero)
            Arguments.of(Arrays.asList("/"), Arrays.asList(3, 0), ArithmeticException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidAlgebraData")
    public void testDoAlgebraInvalidInputs(List<String> ops, List<Integer> nums, Class<? extends Throwable> expectedException) {
        HumanEval160 s = new HumanEval160();
        assertThrows(expectedException,
                () -> s.doAlgebra(new ArrayList<>(ops), new ArrayList<>(nums)));
    }
}
