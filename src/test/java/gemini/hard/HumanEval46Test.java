package gemini.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval46Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideFib4Data() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of(0, 0),
            org.junit.jupiter.params.provider.Arguments.of(1, 0),
            org.junit.jupiter.params.provider.Arguments.of(2, 2),
            org.junit.jupiter.params.provider.Arguments.of(3, 0),
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
        assertEquals(expected, s.fib4(input), "fib4 returned incorrect value");
    }
}
