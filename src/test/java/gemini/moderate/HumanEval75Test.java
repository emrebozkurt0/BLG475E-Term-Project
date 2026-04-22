package gemini.moderate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval75Test {

    @ParameterizedTest
    @CsvSource({
        "30, true",
        "8, true",
        "125, true",
        "105, true",
        "1001, true",
        "5, false",
        "10, false",
        "126, false",
        "729, false",
        "891, false",
        "1, false",   // Mutated edge case
        "0, false",   // Mutated edge case
        "-5, false"   // Mutated negative boundary
    })
    public void testIsMultiplyPrime(int input, boolean expected) {
        HumanEval75 s = new HumanEval75();
        assertEquals(expected, s.isMultiplyPrime(input));
    }
}