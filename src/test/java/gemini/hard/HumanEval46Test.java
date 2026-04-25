package gemini.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval46Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideFib4Data() {
        return java.util.stream.Stream.of(
            // Mutation tests for uncovered ECs: EC4 (negative index)
            org.junit.jupiter.params.provider.Arguments.of(-1, -1),
            org.junit.jupiter.params.provider.Arguments.of(0, 0),
            org.junit.jupiter.params.provider.Arguments.of(1, 0),
            org.junit.jupiter.params.provider.Arguments.of(2, 2),
            org.junit.jupiter.params.provider.Arguments.of(3, 0),
            // Mutation tests for uncovered ECs: EC2 (first recursive index)
            org.junit.jupiter.params.provider.Arguments.of(4, 2),
            org.junit.jupiter.params.provider.Arguments.of(5, 4),
            org.junit.jupiter.params.provider.Arguments.of(8, 28),
            org.junit.jupiter.params.provider.Arguments.of(10, 104),
            org.junit.jupiter.params.provider.Arguments.of(12, 386)
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideFib4Data")
    public void testFib4(int input, int expected) {
        HumanEval46 s = new HumanEval46();
        if (input < 0) {
            assertThrows(IndexOutOfBoundsException.class, () -> s.fib4(input),
                    "Negative indices should throw on this implementation");
        } else {
            assertEquals(expected, s.fib4(input), "fib4 returned incorrect value");
        }
    }
}
