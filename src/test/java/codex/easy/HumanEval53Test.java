package codex.easy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval53Test {
    @ParameterizedTest
    @MethodSource("addCases")
    public void testAdd(int left, int right, int expected) {
        HumanEval53 s = new HumanEval53();
        assertEquals(expected, s.add(left, right));
    }

    private static Stream<Arguments> addCases() {
        return Stream.of(
                Arguments.of(0, 1, 1),
                Arguments.of(1, 0, 1),
                Arguments.of(2, 3, 5),
                Arguments.of(5, 7, 12),
                Arguments.of(7, 5, 12),
                Arguments.of(123, 456, 579),
                Arguments.of(999, 1, 1000),
                Arguments.of(678, 654, 1332),
                Arguments.of(21, 21, 42),
                Arguments.of(99, 99, 198)
        );
    }
}