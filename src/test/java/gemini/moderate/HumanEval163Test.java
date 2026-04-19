package gemini.moderate;

import java.util.*;
import java.lang.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval163Test {
    @Test
    public void testSolution() {
        HumanEval163 s = new HumanEval163();
        List<Boolean> correct = Arrays.asList(
                s.generateIntegers(2, 10).equals(Arrays.asList(2, 4, 6, 8)),
                s.generateIntegers(10, 2).equals(Arrays.asList(2, 4, 6, 8)),
                s.generateIntegers(132, 2).equals(Arrays.asList(2, 4, 6, 8)),
                s.generateIntegers(17, 89).equals(List.of())
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}