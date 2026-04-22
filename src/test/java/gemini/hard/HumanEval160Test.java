package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval160Test {
    @Test
    public void testDoAlgebra1() {
        HumanEval160 s = new HumanEval160();
        assertEquals(37, s.doAlgebra(
            new ArrayList<>(Arrays.asList("**", "*", "+")), 
            new ArrayList<>(Arrays.asList(2, 3, 4, 5))
        ));
    }

    @Test
    public void testDoAlgebra2() {
        HumanEval160 s = new HumanEval160();
        assertEquals(9, s.doAlgebra(
            new ArrayList<>(Arrays.asList("+", "*", "-")), 
            new ArrayList<>(Arrays.asList(2, 3, 4, 5))
        ));
    }

    @Test
    public void testDoAlgebra3() {
        HumanEval160 s = new HumanEval160();
        assertEquals(8, s.doAlgebra(
            new ArrayList<>(Arrays.asList("/", "*")), 
            new ArrayList<>(Arrays.asList(7, 3, 4))
        ));
    }

    @Test
    public void testDoAlgebra4() {
        HumanEval160 s = new HumanEval160();
        assertEquals(1953132, s.doAlgebra(
            new ArrayList<>(Arrays.asList("+", "**", "**")), 
            new ArrayList<>(Arrays.asList(7, 5, 3, 2))
        ));
    }

    @Test
    public void testDoAlgebraFloorDivision() {
        HumanEval160 s = new HumanEval160();
        assertEquals(2, s.doAlgebra(
            new ArrayList<>(Arrays.asList("//")), 
            new ArrayList<>(Arrays.asList(7, 3))
        ));
    }

    @Test
    public void testDoAlgebraInvalidOperator() {
        HumanEval160 s = new HumanEval160();
        assertEquals(2, s.doAlgebra(
            new ArrayList<>(Arrays.asList("?")), 
            new ArrayList<>(Arrays.asList(2, 3))
        ));
    }
}
