package codex.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HumanEval32Test {

    @Test
    public void findZero_returnsExpectedRootForLinearPolynomial() {
        HumanEval32 solution = new HumanEval32();
        double root = solution.findZero(Arrays.asList(1.0, 2.0));

        assertEquals(-0.5, root, 1e-4);
        assertTrue(Math.abs(solution.poly(Arrays.asList(1.0, 2.0), root)) < 1e-8);
    }

    @Test
    public void findZero_returnsExpectedRootForCubicPolynomial() {
        HumanEval32 solution = new HumanEval32();
        double root = solution.findZero(Arrays.asList(-6.0, 11.0, -6.0, 1.0));

        assertEquals(1.0, root, 1e-4);
        assertTrue(Math.abs(solution.poly(Arrays.asList(-6.0, 11.0, -6.0, 1.0), root)) < 1e-6);
    }

    @Test
    public void findZero_returnsLeftEndpointWhenItIsRoot() {
        HumanEval32 solution = new HumanEval32();
        double root = solution.findZero(Arrays.asList(1.0, 1.0));

        assertEquals(-1.0, root, 1e-12);
    }

    @Test
    public void findZero_handlesRootOutsideInitialIntervalByExpandingBounds() {
        HumanEval32 solution = new HumanEval32();
        double root = solution.findZero(Arrays.asList(-10.0, 1.0));

        assertEquals(10.0, root, 1e-6);
        assertTrue(Math.abs(solution.poly(Arrays.asList(-10.0, 1.0), root)) < 1e-6);
    }

    @Test
    public void findZero_takesBisectionElseBranchBeforeConverging() {
        HumanEval32 solution = new HumanEval32();
        double root = solution.findZero(Arrays.asList(-0.75, 1.0));

        assertEquals(0.75, root, 1e-6);
        assertTrue(Math.abs(solution.poly(Arrays.asList(-0.75, 1.0), root)) < 1e-10);
    }

    @Test
    public void findZero_returnsFiniteFallbackWhenNoRealRootExists() {
        HumanEval32 solution = new HumanEval32();
        double root = solution.findZero(Arrays.asList(1.0, 0.0, 1.0));

        assertTrue(Double.isFinite(root));
        assertTrue(solution.poly(Arrays.asList(1.0, 0.0, 1.0), root) > 0.0);
    }
}
