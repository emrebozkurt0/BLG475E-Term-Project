package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HumanEval163Test {
    static Stream<Arguments> generateIntegersCases() {
        return Stream.of(
                Arguments.of(2, 10, Arrays.asList(2, 4, 6, 8)),
                Arguments.of(10, 2, Arrays.asList(2, 4, 6, 8)),
                Arguments.of(132, 2, Arrays.asList(2, 4, 6, 8)),
            Arguments.of(17, 89, List.of()),
            Arguments.of(9, 10, List.of()),
            Arguments.of(8, 8, List.of(8)),
            Arguments.of(1, 1, List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("generateIntegersCases")
    public void testGenerateIntegers(int a, int b, List<Integer> expected) {
        HumanEval_163 s = new HumanEval_163();
        assertEquals(expected, s.generateIntegers(a, b),
            "generateIntegers should match expected for a=" + a + ", b=" + b);
    }
}