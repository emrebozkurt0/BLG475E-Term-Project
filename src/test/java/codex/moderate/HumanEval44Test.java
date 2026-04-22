package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HumanEval44Test {
    @ParameterizedTest
    @CsvSource({
            "8, 3, 22",
            "9, 3, 100",
            "234, 2, 11101010",
            "16, 2, 10000",
            "8, 2, 1000",
            "7, 2, 111",
            "2, 3, 2",
            "3, 4, 3",
            "4, 5, 4",
            "5, 6, 5",
            "6, 7, 6",
            "7, 8, 7"
    })
    public void testChangeBase(int x, int base, String expected) {
        HumanEval_44 s = new HumanEval_44();
        assertEquals(expected, s.changeBase(x, base),
            "base conversion should match expected for x=" + x + ", base=" + base);
    }

    @Test
    public void mutationBoundaryCasesForChangeBase() {
        HumanEval_44 s = new HumanEval_44();
        int oneValue = 1;
        int binaryBase = 2;
        String oneInBinary = "1";
        int nineValue = 9;
        String nineInBinary = "1001";
        int baseNine = 9;
        String nineInBaseNine = "10";

        assertEquals(oneInBinary, s.changeBase(oneValue, binaryBase),
            "mutation conversion case failed for x=" + oneValue + ", base=" + binaryBase);
        assertEquals(nineInBinary, s.changeBase(nineValue, binaryBase),
            "mutation conversion case failed for x=" + nineValue + ", base=" + binaryBase);
        assertEquals(nineInBaseNine, s.changeBase(nineValue, baseNine),
            "mutation conversion case failed for x=" + nineValue + ", base=" + baseNine);
        int invalidBaseInput = 10;
        int invalidBase = 0;
        assertThrows(ArithmeticException.class, () -> s.changeBase(invalidBaseInput, invalidBase),
            "base 0 should throw ArithmeticException");
    }
}