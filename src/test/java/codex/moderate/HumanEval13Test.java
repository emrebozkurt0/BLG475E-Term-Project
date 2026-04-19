package codex.moderate;

import java.util.*;
import java.lang.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval13Test {
    @Test
    public void testSolution() {
        HumanEval_13 s = new HumanEval_13();
        List<Boolean> correct = Arrays.asList(
                s.greatestCommonDivisor(3, 7) == 1,
                s.greatestCommonDivisor(10, 15) == 5,
                s.greatestCommonDivisor(49, 14) == 7,
                s.greatestCommonDivisor(144, 60) == 12
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}