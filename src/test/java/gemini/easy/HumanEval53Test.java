package gemini.easy;

import java.util.*;
import java.lang.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval53Test {
    @Test
    public void testSolution() {
        HumanEval53 s = new HumanEval53();
        List<Boolean> correct = Arrays.asList(
                s.add(0, 1) == 1,
                s.add(1, 0) == 1,
                s.add(2, 3) == 5,
                s.add(5, 7) == 12,
                s.add(7, 5) == 12
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int x = rand.nextInt(1000);
            int y = rand.nextInt(1000);
            if (s.add(x, y) != x + y) {
                throw new AssertionError();
            }
        }
    }
}
