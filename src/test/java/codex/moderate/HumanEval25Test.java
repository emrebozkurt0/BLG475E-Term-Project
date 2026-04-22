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

public class HumanEval25Test {
    static Stream<Arguments> factorizeCases() {
        return Stream.of(
                Arguments.of(2, List.of(2)),
                Arguments.of(4, Arrays.asList(2, 2)),
                Arguments.of(8, Arrays.asList(2, 2, 2)),
                Arguments.of(3 * 19, Arrays.asList(3, 19)),
                Arguments.of(3 * 19 * 3 * 19, Arrays.asList(3, 3, 19, 19)),
                Arguments.of(3 * 19 * 3 * 19 * 3 * 19, Arrays.asList(3, 3, 3, 19, 19, 19)),
                Arguments.of(3 * 19 * 19 * 19, Arrays.asList(3, 19, 19, 19)),
                Arguments.of(3 * 2 * 3, Arrays.asList(2, 3, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("factorizeCases")
    public void testFactorize(int input, List<Integer> expected) {
        HumanEval_25 s = new HumanEval_25();
        assertEquals(expected, s.factorize(input),
            "factorization should match expected for input=" + input);
    }

    @Test
    public void mutationBoundaryCasesForFactorize() {
        HumanEval_25 s = new HumanEval_25();
        int inputOne = 1;
        int repeatedPrimeFactor = 7;
        int squareOfPrime = 49;
        int primeNumber = 97;

        assertEquals(Collections.emptyList(), s.factorize(inputOne),
            "factorization of 1 should be empty");
        assertEquals(Arrays.asList(repeatedPrimeFactor, repeatedPrimeFactor), s.factorize(squareOfPrime),
            "factorization should include repeated prime factors");
        assertEquals(Collections.singletonList(primeNumber), s.factorize(primeNumber),
            "factorization of a prime should contain only itself");
    }
}