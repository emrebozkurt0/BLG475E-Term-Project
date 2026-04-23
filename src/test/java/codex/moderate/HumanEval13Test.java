package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                "144, 60, 12",
                "0, 0, 0",
                "1, 1, 1",
                "18, 24, 6"
    })
    public void testGreatestCommonDivisor(int a, int b, int expected) {
        HumanEval_13 s = new HumanEval_13();
        assertEquals(expected, s.greatestCommonDivisor(a, b),
                "gcd should match expected for a=" + a + ", b=" + b);
    }
}