package codex.easy;

import java.util.*;
import java.lang.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval28Test {
    @Test
    public void testSolution() {
        HumanEval28 s = new HumanEval28();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.concatenate(new ArrayList<>(List.of())), ""),
                Objects.equals(s.concatenate(new ArrayList<>(Arrays.asList("x", "y", "z"))), "xyz"),
                Objects.equals(s.concatenate(new ArrayList<>(Arrays.asList("x", "y", "z", "w", "k"))), "xyzwk")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}