package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HumanEval13Test {
    @ParameterizedTest
    @CsvSource({
            "0, 5, 5",
            "7, 0, 7",
            "9, 9, 9",
            "3, 7, 1",
            "10, 15, 5",
            "49, 14, 7",
            "144, 60, 12"
    })
    public void testGreatestCommonDivisor(int a, int b, int expected) {
        HumanEval_13 s = new HumanEval_13();
        assertEquals(expected, s.greatestCommonDivisor(a, b),
                "gcd should match expected for a=" + a + ", b=" + b);
    }

    @Test
    public void mutationBoundaryCasesForGreatestCommonDivisor() {
        HumanEval_13 s = new HumanEval_13();
        int bothZeroA = 0;
        int bothZeroB = 0;
        int bothZeroExpected = 0;
        int equalOneA = 1;
        int equalOneB = 1;
        int equalOneExpected = 1;
        int divisiblePairA = 18;
        int divisiblePairB = 24;
        int divisiblePairExpected = 6;

        assertEquals(bothZeroExpected, s.greatestCommonDivisor(bothZeroA, bothZeroB),
            "gcd mutation case failed for a=" + bothZeroA + ", b=" + bothZeroB);
        assertEquals(equalOneExpected, s.greatestCommonDivisor(equalOneA, equalOneB),
            "gcd mutation case failed for a=" + equalOneA + ", b=" + equalOneB);
        assertEquals(divisiblePairExpected, s.greatestCommonDivisor(divisiblePairA, divisiblePairB),
            "gcd mutation case failed for a=" + divisiblePairA + ", b=" + divisiblePairB);
    }
}