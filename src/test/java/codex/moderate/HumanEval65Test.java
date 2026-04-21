package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(expected, s.circularShift(input, shift));
    }
}