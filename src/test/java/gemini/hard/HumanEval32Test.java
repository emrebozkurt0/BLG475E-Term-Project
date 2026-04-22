package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval32Test {
    @Test
    public void testPoly() {
        HumanEval32 s = new HumanEval32();
        assertEquals(0.0, s.poly(Arrays.asList(1.0, 2.0), -0.5), 1e-4);
    }

    @Test
    public void testFindZero1() {
        HumanEval32 s = new HumanEval32();
        assertEquals(-0.5, s.findZero(Arrays.asList(1.0, 2.0)), 1e-4);
    }

    @Test
    public void testFindZero2() {
        HumanEval32 s = new HumanEval32();
        assertEquals(1.0, s.findZero(Arrays.asList(-6.0, 11.0, -6.0, 1.0)), 1e-4);
    }
}
