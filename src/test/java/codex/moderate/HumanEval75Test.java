package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HumanEval75Test {
    @ParameterizedTest
    @CsvSource({
            "5, false",
            "30, true",
            "8, true",
            "10, false",
            "125, true",
            "105, true",
            "126, false",
            "729, false",
            "891, false",
            "1001, true"
    })
    public void testIsMultiplyPrime(int input, boolean expected) {
        HumanEval_75 s = new HumanEval_75();
        assertEquals(expected, s.isMultiplyPrime(input));
    }
}