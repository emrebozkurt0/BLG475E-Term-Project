package gemini.moderate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval65Test {

    @Test
    public void testCircularShift() {
        HumanEval65 s = new HumanEval65();
        
        String exp1 = "001"; int x1 = 100, shift1 = 2;
        assertEquals(exp1, s.circularShift(x1, shift1), "Shift 100 by 2 should be 001");
        
        String exp2 = "12"; int x2 = 12, shift2 = 2;
        assertEquals(exp2, s.circularShift(x2, shift2), "Shift 12 by 2 should be 12");
        
        String exp3 = "21"; int x3 = 12, shift3 = 1;
        assertEquals(exp3, s.circularShift(x3, shift3), "Shift 12 by 1 should be 21");
        
        String exp4 = "79"; int x4 = 97, shift4 = 8;
        assertEquals(exp4, s.circularShift(x4, shift4), "Shift 97 by 8 should be 79");
        
        String exp5 = "11"; int x5 = 11, shift5 = 101;
        assertEquals(exp5, s.circularShift(x5, shift5), "Shift 11 by 101 should be 11");

        // Mutated tests for shift boundaries
        String exp6 = "12"; int x6 = 12, shift6 = 0;
        assertEquals(exp6, s.circularShift(x6, shift6), "Shift by 0 should return string itself");
        
        String exp7 = "12"; int x7 = 12, shift7 = 2;
        assertEquals(exp7, s.circularShift(x7, shift7), "Shift equal to length should act properly");
    }
}