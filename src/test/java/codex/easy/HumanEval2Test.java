package codex.easy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval2Test {
    private static final double EPSILON = 1e-6;

    @ParameterizedTest
    @MethodSource("truncateNumberCases")
    public void testTruncateNumber(double input, double expected) {
        HumanEval2 s = new HumanEval2();
        assertEquals(expected, s.truncateNumber(input), EPSILON);
    }

    private static Stream<Arguments> truncateNumberCases() {
        return Stream.of(
                Arguments.of(3.5, 0.5),
                Arguments.of(1.33, 0.33),
                Arguments.of(123.456, 0.456)
        );
    }
}