package codex.easy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval45Test {
    private static final double EPSILON = 1e-9;

    @ParameterizedTest
    @MethodSource("triangleAreaCases")
    public void testTriangleArea(int base, int height, double expected) {
        HumanEval45 s = new HumanEval45();
        assertEquals(expected, s.triangleArea(base, height), EPSILON);
    }

    private static Stream<Arguments> triangleAreaCases() {
        return Stream.of(
                Arguments.of(5, 3, 7.5),
                Arguments.of(2, 2, 2.0),
                Arguments.of(10, 8, 40.0)
        );
    }
}