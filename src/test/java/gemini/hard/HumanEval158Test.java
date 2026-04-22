package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval158Test {
    @Test
    public void testFindMaxTieLexicographical() {
        HumanEval158 s = new HumanEval158();
        assertEquals("enam", s.findMax(Arrays.asList("name", "enam", "game")));
        assertEquals("abc", s.findMax(Arrays.asList("abc", "cba")));
    }

    @Test
    public void testFindMaxUnique() {
        HumanEval158 s = new HumanEval158();
        assertEquals("string", s.findMax(Arrays.asList("name", "of", "string")));
        assertEquals("aaaaaaa", s.findMax(Arrays.asList("aaaaaaa", "bb", "cc")));
        assertEquals("footbott", s.findMax(Arrays.asList("play", "this", "game", "of", "footbott")));
    }

    @Test
    public void testFindMaxMisc() {
        HumanEval158 s = new HumanEval158();
        assertEquals("gonna", s.findMax(Arrays.asList("we", "are", "gonna", "rock")));
        assertEquals("nation", s.findMax(Arrays.asList("we", "are", "a", "mad", "nation")));
        assertEquals("this", s.findMax(Arrays.asList("this", "is", "a", "prrk")));
        assertEquals("b", s.findMax(Arrays.asList("b")));
        assertEquals("play", s.findMax(Arrays.asList("play", "play", "play")));
    }
}
