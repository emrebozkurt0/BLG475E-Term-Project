package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HumanEval94Test {
    static Stream<Arguments> skjkasdkdCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(0, 3, 2, 1, 3, 5, 7, 4, 5, 5, 5, 2, 181, 32, 4, 32, 3, 2, 32, 324, 4, 3), 10),
                Arguments.of(Arrays.asList(1, 0, 1, 8, 2, 4597, 2, 1, 3, 40, 1, 2, 1, 2, 4, 2, 5, 1), 25),
                Arguments.of(Arrays.asList(1, 3, 1, 32, 5107, 34, 83278, 109, 163, 23, 2323, 32, 30, 1, 9, 3), 13),
                Arguments.of(Arrays.asList(0, 724, 32, 71, 99, 32, 6, 0, 5, 91, 83, 0, 5, 6), 11),
                Arguments.of(Arrays.asList(0, 81, 12, 3, 1, 21), 3),
                Arguments.of(Arrays.asList(0, 8, 1, 2, 1, 7), 7),
                Arguments.of(List.of(8191), 19),
                Arguments.of(Arrays.asList(8191, 123456, 127, 7), 19),
                Arguments.of(Arrays.asList(127, 97, 8192), 10)
        );
    }

    @ParameterizedTest
    @MethodSource("skjkasdkdCases")
    public void testSkjkasdkd(List<Integer> input, int expected) {
        HumanEval_94 s = new HumanEval_94();
        assertEquals(expected, s.skjkasdkd(input));
    }
}