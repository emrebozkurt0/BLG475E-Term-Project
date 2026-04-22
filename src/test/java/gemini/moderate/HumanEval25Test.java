package gemini.moderate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval25Test {

    static Stream<Arguments> provideFactorizeCases() {
        return Stream.of(
            Arguments.of(2, Arrays.asList(2)),
            Arguments.of(4, Arrays.asList(2, 2)),
            Arguments.of(8, Arrays.asList(2, 2, 2)),
            Arguments.of(18, Arrays.asList(2, 3, 3)),
            Arguments.of(57, Arrays.asList(3, 19)),
            Arguments.of(3249, Arrays.asList(3, 3, 19, 19)),
            Arguments.of(185193, Arrays.asList(3, 3, 3, 19, 19, 19)),
            Arguments.of(20577, Arrays.asList(3, 19, 19, 19)),
            Arguments.of(0, Arrays.asList()),
            Arguments.of(1, Arrays.asList()),
            Arguments.of(-5, Arrays.asList())
        );
    }

    @ParameterizedTest
    @MethodSource("provideFactorizeCases")
    public void testFactorize(int input, List<Integer> expected) {
        HumanEval25 s = new HumanEval25();
        assertEquals(expected, s.factorize(input), "Factorize " + input);
    }
}