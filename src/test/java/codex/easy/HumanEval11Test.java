package codex.easy;

import java.util.*;
import java.lang.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval11Test {
    @Test
    public void testSolution() {
        HumanEval11 s = new HumanEval11();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.stringXor("111000", "101010"), "010010"),
                Objects.equals(s.stringXor("1", "1"), "0"),
                Objects.equals(s.stringXor("0101", "0000"), "0101")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}