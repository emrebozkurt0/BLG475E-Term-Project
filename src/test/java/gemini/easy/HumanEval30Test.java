package gemini.easy;

import java.util.*;
import java.lang.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval30Test {
    @Test
    public void testSolution() {
        HumanEval30 s = new HumanEval30();
        List<Boolean> correct = Arrays.asList(
                s.getPositive(new ArrayList<>(Arrays.asList(-1, -2, 4, 5, 6))).equals(Arrays.asList(4, 5, 6)),
                s.getPositive(new ArrayList<>(Arrays.asList(5, 3, -5, 2, 3, 3, 9, 0, 123, 1, -10))).equals(Arrays.asList(5, 3, 2, 3, 3, 9, 123, 1))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
