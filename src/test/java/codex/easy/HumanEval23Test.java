package codex.easy;

import java.util.*;
import java.lang.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval23Test {
    @Test
    public void testSolution() {
        HumanEval23 s = new HumanEval23();
        List<Boolean> correct = Arrays.asList(
                s.strlen("") == 0,
                s.strlen("x") == 1,
                s.strlen("asdfgh") == 6
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}