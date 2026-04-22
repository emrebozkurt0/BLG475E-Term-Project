package gemini.easy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class HumanEval2Test {
    @ParameterizedTest
    @CsvSource({
        "3.5, 0.5", "1.33, 0.33", "123.456, 0.456", 
        "-1.5, -0.5", // mutated edge case: negative decimal
        "0.0, 0.0",   // mutated edge case: zero boundary
        "5.0, 0.0"    // mutated edge case: whole number
    })
    public void testTruncateNumber(double input, double expected) {
        HumanEval2 s = new HumanEval2();
        double delta = 1e-6;
        double result = s.truncateNumber(input);
        assertEquals(expected, result, delta);
    }

}
