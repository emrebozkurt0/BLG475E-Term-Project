package gemini.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval46Test {
    @Test
    public void testFib4BaseCases() {
        HumanEval46 s = new HumanEval46();
        assertEquals(0, s.fib4(0));
        assertEquals(0, s.fib4(1));
        assertEquals(2, s.fib4(2));
        assertEquals(0, s.fib4(3));
    }

    @Test
    public void testFib4Normal() {
        HumanEval46 s = new HumanEval46();
        assertEquals(4, s.fib4(5));
        assertEquals(28, s.fib4(8));
        assertEquals(104, s.fib4(10));
        assertEquals(386, s.fib4(12));
    }
}
