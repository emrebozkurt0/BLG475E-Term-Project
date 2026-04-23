package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
            "7, 8, 7",
            "1, 2, 1",
            "9, 2, 1001",
            "9, 9, 10"
    })
    public void testChangeBase(int x, int base, String expected) {
        HumanEval_44 s = new HumanEval_44();
        assertEquals(expected, s.changeBase(x, base),
            "base conversion should match expected for x=" + x + ", base=" + base);
    }
}