package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HumanEval65Test {
    @ParameterizedTest
    @CsvSource({
            "100, 2, 001",
            "12, 2, 12",
            "97, 8, 79",
            "12, 1, 21",
            "11, 101, 11"
    })
    public void testCircularShift(int input, int shift, String expected) {
        HumanEval_65 s = new HumanEval_65();
        assertEquals(expected, s.circularShift(input, shift),
            "circularShift should match expected for input=" + input + ", shift=" + shift);
    }

    @Test
    public void mutationBoundaryCasesForCircularShift() {
        HumanEval_65 s = new HumanEval_65();
        int inputWithFourDigits = 1234;
        int zeroShift = 0;
        int sameLengthShift = 4;
        int largerThanLengthShift = 5;
        int singleDigitInput = 7;
        int singleDigitShift = 1;

        assertEquals("1234", s.circularShift(inputWithFourDigits, zeroShift),
            "mutation circular shift case failed for input=" + inputWithFourDigits + ", shift=" + zeroShift);
        assertEquals("1234", s.circularShift(inputWithFourDigits, sameLengthShift),
            "mutation circular shift case failed for input=" + inputWithFourDigits + ", shift=" + sameLengthShift);
        assertEquals("4321", s.circularShift(inputWithFourDigits, largerThanLengthShift),
            "mutation circular shift case failed for input=" + inputWithFourDigits + ", shift=" + largerThanLengthShift);
        assertEquals("7", s.circularShift(singleDigitInput, singleDigitShift),
            "mutation circular shift case failed for input=" + singleDigitInput + ", shift=" + singleDigitShift);
        int negativeShift = -1;
        assertThrows(StringIndexOutOfBoundsException.class, () -> s.circularShift(inputWithFourDigits, negativeShift),
            "negative shift should throw StringIndexOutOfBoundsException");
    }
}