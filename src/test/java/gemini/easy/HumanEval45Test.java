package gemini.easy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class HumanEval45Test {
    @ParameterizedTest
    @CsvSource({"5, 3, 7.5", "2, 2, 2.0", "10, 8, 40.0"})
    public void testTriangleArea(int a, int h, double expected) {
        HumanEval45 s = new HumanEval45();
        double result = s.triangleArea(a, h);
        assertEquals(expected, result);
    }
}