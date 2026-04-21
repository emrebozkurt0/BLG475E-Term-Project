package gemini.moderate;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval163Test {

    @Test
    public void testGenerateIntegers() {
        HumanEval163 s = new HumanEval163();
        
        int a1 = 2, b1 = 10;
        List<Integer> expectedNormal = Arrays.asList(2, 4, 6, 8);
        assertEquals(expectedNormal, s.generateIntegers(a1, b1), "Expected even integers in normal order");
        
        int a2 = 10, b2 = 2;
        List<Integer> expectedReverse1 = Arrays.asList(2, 4, 6, 8);
        assertEquals(expectedReverse1, s.generateIntegers(a2, b2), "Expected even integers in reverse order");
        
        int a3 = 132, b3 = 2;
        List<Integer> expectedReverse2 = Arrays.asList(2, 4, 6, 8);
        assertEquals(expectedReverse2, s.generateIntegers(a3, b3), "Expected even integers when left > 9");
        
        int a4 = 17, b4 = 89;
        List<Integer> expectedOut = List.of();
        assertEquals(expectedOut, s.generateIntegers(a4, b4), "Expected empty list out of range");
        
        int a5 = 3, b5 = 7;
        List<Integer> expectedOdd = Arrays.asList(4, 6);
        assertEquals(expectedOdd, s.generateIntegers(a5, b5), "Expected even integers for odd bounds");
    }
}