package codex.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval46Test {

    @ParameterizedTest(name = "fib4({0}) -> {1}")
    @MethodSource("fib4Cases")
    public void fib4_returnsExpectedValues(int n, int expected) {
        HumanEval46 solution = new HumanEval46();
        assertEquals(expected, solution.fib4(n));
    }

    private static Stream<Arguments> fib4Cases() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 0),
                Arguments.of(2, 2),
                Arguments.of(3, 0),
                Arguments.of(4, 2),
                Arguments.of(5, 4),
                Arguments.of(8, 28),
                Arguments.of(10, 104),
                Arguments.of(12, 386)
        );
    }
}
