package gemini.easy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class HumanEval11Test {
    @ParameterizedTest
    @CsvSource({"111000, 101010, 010010", "1, 1, 0", "0101, 0000, 0101"})
    public void testStringXor(String a, String b, String expected) {
        HumanEval11 s = new HumanEval11();
        String result = s.stringXor(a, b);
        assertEquals(expected, result);
    }
}