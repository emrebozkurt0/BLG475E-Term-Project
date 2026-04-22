package gemini.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HumanEval32Test {
    @Test
    public void testSolution() {
        HumanEval32 s = new HumanEval32();
        List<Boolean> correct = Arrays.asList(
                Math.abs(s.findZero(Arrays.asList(1.0, 2.0)) - (-0.5)) < 1e-4,
                Math.abs(s.findZero(Arrays.asList(-6.0, 11.0, -6.0, 1.0)) - (1.0)) < 1e-4
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
