package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HumanEval163Test {
    static Stream<Arguments> generateIntegersCases() {
        return Stream.of(
                Arguments.of(2, 10, Arrays.asList(2, 4, 6, 8)),
                Arguments.of(10, 2, Arrays.asList(2, 4, 6, 8)),
                Arguments.of(132, 2, Arrays.asList(2, 4, 6, 8)),
                Arguments.of(17, 89, List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("generateIntegersCases")
    public void testGenerateIntegers(int a, int b, List<Integer> expected) {
        HumanEval_163 s = new HumanEval_163();
        assertEquals(expected, s.generateIntegers(a, b),
            "generateIntegers should match expected for a=" + a + ", b=" + b);
    }

    @Test
    public void mutationBoundaryCasesForGenerateIntegers() {
        HumanEval_163 s = new HumanEval_163();
        int lowerBoundaryNine = 9;
        int firstDoubleDigit = 10;
        int repeatedEight = 8;
        int repeatedOne = 1;

        assertEquals(Collections.emptyList(), s.generateIntegers(lowerBoundaryNine, firstDoubleDigit),
            "range [9,10] should not contain even digits <= 9");
        assertEquals(Collections.singletonList(repeatedEight), s.generateIntegers(repeatedEight, repeatedEight),
            "range [8,8] should include only 8");
        assertEquals(Collections.emptyList(), s.generateIntegers(repeatedOne, repeatedOne),
            "range [1,1] should be empty");
    }
}