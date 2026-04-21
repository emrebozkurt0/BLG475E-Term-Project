package codex.easy;

import java.util.*;
import java.lang.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval45Test {
    @Test
    public void testSolution() {
        HumanEval45 s = new HumanEval45();
        List<Boolean> correct = Arrays.asList(
                s.triangleArea(5, 3) == 7.5,
                s.triangleArea(2, 2) == 2.0,
                s.triangleArea(10, 8) == 40.0
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}