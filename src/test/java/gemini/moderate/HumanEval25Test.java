package gemini.moderate;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval25Test {

    @Test
    public void testFactorize() {
        HumanEval25 s = new HumanEval25();
        
        int in1 = 2; List<Integer> exp1 = Arrays.asList(2);
        assertEquals(exp1, s.factorize(in1), "Factorize 2");
        
        int in2 = 4; List<Integer> exp2 = Arrays.asList(2, 2);
        assertEquals(exp2, s.factorize(in2), "Factorize 4");
        
        int in3 = 8; List<Integer> exp3 = Arrays.asList(2, 2, 2);
        assertEquals(exp3, s.factorize(in3), "Factorize 8");
        
        int in4 = 18; List<Integer> exp4 = Arrays.asList(2, 3, 3);
        assertEquals(exp4, s.factorize(in4), "Factorize 18");
        
        int in5 = 3 * 19; List<Integer> exp5 = Arrays.asList(3, 19);
        assertEquals(exp5, s.factorize(in5), "Factorize 57");
        
        int in6 = 3 * 19 * 3 * 19; List<Integer> exp6 = Arrays.asList(3, 3, 19, 19);
        assertEquals(exp6, s.factorize(in6), "Factorize 3249");
        
        int in7 = 3 * 19 * 3 * 19 * 3 * 19; List<Integer> exp7 = Arrays.asList(3, 3, 3, 19, 19, 19);
        assertEquals(exp7, s.factorize(in7), "Factorize 185193");
        
        int in8 = 3 * 19 * 19 * 19; List<Integer> exp8 = Arrays.asList(3, 19, 19, 19);
        assertEquals(exp8, s.factorize(in8), "Factorize 20577");
    }
}