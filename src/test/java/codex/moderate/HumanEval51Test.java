package codex.moderate;

import java.util.*;
import java.lang.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval51Test {
    @Test
    public void testSolution() {
        HumanEval_51 s = new HumanEval_51();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.removeVowels(""), ""),
                Objects.equals(s.removeVowels("abcdef\nghijklm"), "bcdf\nghjklm"),
                Objects.equals(s.removeVowels("fedcba"), "fdcb"),
                Objects.equals(s.removeVowels("eeeee"), ""),
                Objects.equals(s.removeVowels("acBAA"), "cB"),
                Objects.equals(s.removeVowels("EcBOO"), "cB"),
                Objects.equals(s.removeVowels("ybcd"), "ybcd")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}