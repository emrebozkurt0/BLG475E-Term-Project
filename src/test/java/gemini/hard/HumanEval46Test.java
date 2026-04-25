package gemini.hard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval46Test {
    static Stream<Arguments> provideFib4Data() {
        return Stream.of(
            Arguments.of(0, 0),
            Arguments.of(1, 0),
            Arguments.of(2, 2),
            Arguments.of(3, 0),
            // Mutation tests for uncovered ECs: EC2 (first recursive index)
            Arguments.of(4, 2),
            Arguments.of(5, 4),
            Arguments.of(8, 28),
            Arguments.of(10, 104),
            Arguments.of(12, 386)
        );
    }

    static Stream<Integer> provideNegativeFib4Inputs() {
        // Mutation tests for uncovered ECs: EC4 (negative index)
        return Stream.of(-1);
    }

    @ParameterizedTest
    @MethodSource("provideFib4Data")
    public void testFib4(int input, int expected) {
        HumanEval46 s = new HumanEval46();
        assertEquals(expected, s.fib4(input), "fib4 returned incorrect value");
    }

    @ParameterizedTest
    @MethodSource("provideNegativeFib4Inputs")
    public void testFib4NegativeInputThrows(int input) {
        HumanEval46 s = new HumanEval46();
        assertThrows(IndexOutOfBoundsException.class, () -> s.fib4(input),
                "Negative indices should throw on this implementation");
    }
}
