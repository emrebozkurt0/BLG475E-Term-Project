package codex.easy;

import java.util.*;
import java.lang.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval2Test {
    @Test
    public void testSolution() {
        HumanEval2 s = new HumanEval2();
        List<Boolean> correct = Arrays.asList(
            s.truncateNumber(3.5) == 0.5,
            Math.abs(s.truncateNumber(1.33) - 0.33) < 1e-6,
            Math.abs(s.truncateNumber(123.456) - 0.456) < 1e-6
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}