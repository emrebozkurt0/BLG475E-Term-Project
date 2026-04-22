package gemini.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HumanEval158Test {
    @Test
    public void testSolution() {
        HumanEval158 s = new HumanEval158();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.findMax(Arrays.asList("name", "of", "string")), "string"),
                Objects.equals(s.findMax(Arrays.asList("name", "enam", "game")), "enam"),
                Objects.equals(s.findMax(Arrays.asList("aaaaaaa", "bb", "cc")), "aaaaaaa"),
                Objects.equals(s.findMax(Arrays.asList("abc", "cba")), "abc"),
                Objects.equals(s.findMax(Arrays.asList("play", "this", "game", "of", "footbott")), "footbott"),
                Objects.equals(s.findMax(Arrays.asList("we", "are", "gonna", "rock")), "gonna"),
                Objects.equals(s.findMax(Arrays.asList("we", "are", "a", "mad", "nation")), "nation"),
                Objects.equals(s.findMax(Arrays.asList("this", "is", "a", "prrk")), "this"),
                Objects.equals(s.findMax(Arrays.asList("b")), "b"),
                Objects.equals(s.findMax(Arrays.asList("play", "play", "play")), "play")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
