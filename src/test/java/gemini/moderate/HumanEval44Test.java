package gemini.moderate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        "7, 8, 7",
        "1, 2, 1", // Minimum positive x
        "0, 2, ''" // Mutated boundary condition (x=0). Note: Implementation wrongly returns "" instead of "0"
    })
    public void testChangeBase(int x, int base, String expected) {
        HumanEval44 s = new HumanEval44();
        assertEquals(expected, s.changeBase(x, base));
    }
}