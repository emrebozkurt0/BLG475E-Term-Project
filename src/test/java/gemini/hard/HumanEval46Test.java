package gemini.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval46Test {
    @Test
    public void testFib4() {
        HumanEval46 s = new HumanEval46();
        int[] inputs = {0, 1, 2, 3, 5, 8, 10, 12};
        int[] expectedOutputs = {0, 0, 2, 0, 4, 28, 104, 386};

        for (int i = 0; i < inputs.length; i++) {
            int input = inputs[i];
            int expected = expectedOutputs[i];
            assertEquals(expected, s.fib4(input), "fib4(" + input + ") should return " + expected);
        }
    }
}
