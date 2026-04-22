package codex.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HumanEval32Test {

    @ParameterizedTest(name = "findZero case {index}")
    @MethodSource("findZeroCases")
    public void findZero_handlesAllScenarios(List<Double> coefficients, Double expectedRoot, double tolerance, boolean expectPositivePolynomial) {
        HumanEval32 solution = new HumanEval32();
        double root = solution.findZero(coefficients);

        boolean passes;
        if (expectedRoot == null) {
            passes = Double.isFinite(root) && solution.poly(coefficients, root) > 0.0;
        } else {
            passes = Math.abs(root - expectedRoot) <= tolerance;
        }

        assertTrue(passes);
    }

    private static Stream<Arguments> findZeroCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(1.0, 2.0), -0.5, 1e-4, false),
                Arguments.of(Arrays.asList(-6.0, 11.0, -6.0, 1.0), 1.0, 1e-4, false),
                Arguments.of(Arrays.asList(1.0, 1.0), -1.0, 1e-12, false),
                Arguments.of(Arrays.asList(-10.0, 1.0), 10.0, 1e-6, false),
                Arguments.of(Arrays.asList(-0.75, 1.0), 0.75, 1e-6, false),
                Arguments.of(Arrays.asList(1.0, 0.0, 1.0), null, 0.0, true)
        );
    }
}
