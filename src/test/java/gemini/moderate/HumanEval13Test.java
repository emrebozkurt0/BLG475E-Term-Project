package gemini.moderate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval13Test {
    @Test
    public void testGreatestCommonDivisor() {
        HumanEval13 s = new HumanEval13();
        int expected1 = 1, a1 = 3, b1 = 7;
        assertEquals(expected1, s.greatestCommonDivisor(a1, b1), "Expected GCD of 3 and 7 to be 1");
        
        int expected2 = 5, a2 = 10, b2 = 15;
        assertEquals(expected2, s.greatestCommonDivisor(a2, b2), "Expected GCD of 10 and 15 to be 5");
        
        int exp3 = 7, a3 = 49, b3 = 14;
        assertEquals(exp3, s.greatestCommonDivisor(a3, b3), "Expected GCD of 49 and 14 to be 7");
        
        int exp4 = 12, a4 = 144, b4 = 60;
        assertEquals(exp4, s.greatestCommonDivisor(a4, b4), "Expected GCD of 144 and 60 to be 12");
        
        int exp5 = 5, a5 = 5, b5 = 5;
        assertEquals(exp5, s.greatestCommonDivisor(a5, b5), "Expected GCD of equal values to be the value itself");
        
        int exp6 = 5, a6 = 0, b6 = 5;
        assertEquals(exp6, s.greatestCommonDivisor(a6, b6), "Expected GCD of 0 and 5 to be 5");
        
        int exp7 = 5, a7 = 5, b7 = 0;
        assertEquals(exp7, s.greatestCommonDivisor(a7, b7), "Expected GCD of 5 and 0 to be 5");
    }
}