package codex.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HumanEval46Test {
    @Test
    public void testSolution() {
        HumanEval46 s = new HumanEval46();
        List<Boolean> correct = Arrays.asList(
                s.fib4(5) == 4,
                s.fib4(8) == 28,
                s.fib4(10) == 104,
                s.fib4(12) == 386
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
