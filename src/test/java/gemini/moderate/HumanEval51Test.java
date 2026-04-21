package gemini.moderate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval51Test {

    @Test
    public void testRemoveVowels() {
        HumanEval51 s = new HumanEval51();
        
        String exp1 = "bcdf\nghjklm"; String in1 = "abcdef\nghijklm";
        assertEquals(exp1, s.removeVowels(in1), "Should handle string with newline and vowels");
        
        String exp2 = "fdcb"; String in2 = "fedcba";
        assertEquals(exp2, s.removeVowels(in2), "Should handle reverse alphabet logic");
        
        String exp3 = "cB"; String in3 = "acBAA";
        assertEquals(exp3, s.removeVowels(in3), "Should handle mixed case vowels");
        
        String exp4 = "cB"; String in4 = "EcBOO";
        assertEquals(exp4, s.removeVowels(in4), "Should handle different mixed case vowels");
        
        String exp5 = ""; String in5 = "";
        assertEquals(exp5, s.removeVowels(in5), "Should handle empty string");
        
        String exp6 = ""; String in6 = "eeeee";
        assertEquals(exp6, s.removeVowels(in6), "Should handle string with only vowels");
        
        String exp7 = "ybcd"; String in7 = "ybcd";
        assertEquals(exp7, s.removeVowels(in7), "Should handle string with no vowels");
    }
}