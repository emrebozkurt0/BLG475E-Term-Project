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
            Arguments.of(0, 0, null),
            Arguments.of(1, 0, null),
            Arguments.of(2, 2, null),
            Arguments.of(3, 0, null),
            Arguments.of(4, 2, null),
            Arguments.of(5, 4, null),
            Arguments.of(8, 28, null),
            Arguments.of(10, 104, null),
            Arguments.of(12, 386, null),
            // Mutation tests for uncovered ECs: EC4 (negative index)
            Arguments.of(-1, null, IndexOutOfBoundsException.class)
        );
    }

    private void executeFib4Assertion(HumanEval46 s, int input, Integer expected, Class<? extends Throwable> expectedException) {
        if (expectedException != null) {
            assertThrows(expectedException, () -> s.fib4(input), "Negative indices should throw on this implementation");
        } else {
            assertEquals((int) expected, s.fib4(input), "fib4 returned incorrect value");
        }
    }

    @ParameterizedTest
    @MethodSource("provideFib4Data")
    public void testFib4(int input, Integer expected, Class<? extends Throwable> expectedException) {
        HumanEval46 s = new HumanEval46();
        org.junit.jupiter.api.Assertions.assertNotNull(s);
        executeFib4Assertion(s, input, expected, expectedException);
    }
}
