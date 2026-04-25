package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval32Test {
    @Test
    public void testPoly() {
        HumanEval32 s = new HumanEval32();
        java.util.List<Double> coeffs = Arrays.asList(1.0, 2.0);
        double x = -0.5;
        double expected = 0.0;
        double tolerance = 1e-4;
        assertEquals(expected, s.poly(coeffs, x), tolerance, "poly([1.0, 2.0], -0.5) should be 0.0");
    }

    @Test
    public void testFindZero() {
        HumanEval32 s = new HumanEval32();
        double tolerance = 1e-4;
        
        java.util.List<Double> coeffs1 = Arrays.asList(1.0, 2.0);
        double expected1 = -0.5;
        assertEquals(expected1, s.findZero(coeffs1), tolerance, "findZero([1.0, 2.0]) should be -0.5");
        
        java.util.List<Double> coeffs2 = Arrays.asList(-6.0, 11.0, -6.0, 1.0);
        double expected2 = 1.0;
        assertEquals(expected2, s.findZero(coeffs2), tolerance, "findZero([-6.0, 11.0, -6.0, 1.0]) should be 1.0");

        // Mutation tests for uncovered ECs: EC2 (positive linear root)
        assertEquals(10.0, s.findZero(Arrays.asList(-10.0, 1.0)), tolerance,
            "findZero([-10.0, 1.0]) should be 10.0");

        // Mutation tests for uncovered ECs: EC5 (odd-size coefficients)
        assertEquals(0.0, s.findZero(Arrays.asList(0.0, 1.0, 0.0)), tolerance,
            "Odd-size list with a real root should be handled");

        // Mutation tests for uncovered ECs: EC8 (highest-degree coefficient is zero)
        assertEquals(-0.5, s.findZero(Arrays.asList(1.0, 2.0, 0.0, 0.0)), tolerance,
            "Trailing zero coefficients should reduce to linear behavior");

        // Mutation tests for uncovered ECs: EC7 (empty list)
        assertEquals(-100.0, s.findZero(List.of()), tolerance,
            "Empty coefficient list currently converges to the left bound");
    }

        @Test
        public void testFindZeroMutationNullList() {
        // Mutation tests for uncovered ECs: EC7 (null list)
        HumanEval32 s = new HumanEval32();
        assertThrows(NullPointerException.class, () -> s.findZero(null));
        }
}
