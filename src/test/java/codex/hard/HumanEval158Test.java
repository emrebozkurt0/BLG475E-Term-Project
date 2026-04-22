package codex.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval158Test {

    @Test
    public void findMax_matchesReferenceExamples() {
        HumanEval158 solution = new HumanEval158();

        assertEquals("string", solution.findMax(Arrays.asList("name", "of", "string")));
        assertEquals("enam", solution.findMax(Arrays.asList("name", "enam", "game")));
        assertEquals("aaaaaaa", solution.findMax(Arrays.asList("aaaaaaa", "bb", "cc")));
        assertEquals("abc", solution.findMax(Arrays.asList("abc", "cba")));
        assertEquals("footbott", solution.findMax(Arrays.asList("play", "this", "game", "of", "footbott")));
        assertEquals("gonna", solution.findMax(Arrays.asList("we", "are", "gonna", "rock")));
        assertEquals("nation", solution.findMax(Arrays.asList("we", "are", "a", "mad", "nation")));
        assertEquals("this", solution.findMax(Arrays.asList("this", "is", "a", "prrk")));
        assertEquals("b", solution.findMax(Arrays.asList("b")));
        assertEquals("play", solution.findMax(Arrays.asList("play", "play", "play")));
    }

    @Test
    public void findMax_prefersHigherUniqueCharacterCount() {
        HumanEval158 solution = new HumanEval158();

        assertEquals("abcd", solution.findMax(Arrays.asList("aaaa", "abcd", "ab")));
    }

    @Test
    public void findMax_breaksTieLexicographically() {
        HumanEval158 solution = new HumanEval158();

        assertEquals("ab", solution.findMax(Arrays.asList("ba", "ab")));
    }

    @Test
    public void findMax_handlesSingleWord() {
        HumanEval158 solution = new HumanEval158();

        assertEquals("solo", solution.findMax(List.of("solo")));
    }
}
