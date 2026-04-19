package codex.moderate;

import java.util.*;
import java.lang.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval25Test {
    @Test
    public void testSolution() {
        HumanEval_25 s = new HumanEval_25();
        List<Boolean> correct = Arrays.asList(
                s.factorize(2).equals(List.of(2)),
                s.factorize(4).equals(Arrays.asList(2, 2)),
                s.factorize(8).equals(Arrays.asList(2, 2, 2)),
                s.factorize(3 * 19).equals(Arrays.asList(3, 19)),
                s.factorize(3 * 19 * 3 * 19).equals(Arrays.asList(3, 3, 19, 19)),
                s.factorize(3 * 19 * 3 * 19 * 3 * 19).equals(Arrays.asList(3, 3, 3, 19, 19, 19)),
                s.factorize(3 * 19 * 19 * 19).equals(Arrays.asList(3, 19, 19, 19)),
                s.factorize(3 * 2 * 3).equals(Arrays.asList(2, 3, 3))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}