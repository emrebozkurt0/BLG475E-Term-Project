package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval158Test {
    @Test
    public void testFindMax() {
        HumanEval158 s = new HumanEval158();

        java.util.List<java.util.List<String>> inputLists = Arrays.asList(
            Arrays.asList("name", "enam", "game"),
            Arrays.asList("abc", "cba"),
            Arrays.asList("name", "of", "string"),
            Arrays.asList("aaaaaaa", "bb", "cc"),
            Arrays.asList("play", "this", "game", "of", "footbott"),
            Arrays.asList("we", "are", "gonna", "rock"),
            Arrays.asList("we", "are", "a", "mad", "nation"),
            Arrays.asList("this", "is", "a", "prrk"),
            Arrays.asList("b"),
            Arrays.asList("play", "play", "play")
        );

        String[] expectedOutputs = {
            "enam",
            "abc",
            "string",
            "aaaaaaa",
            "footbott",
            "gonna",
            "nation",
            "this",
            "b",
            "play"
        };

        for (int i = 0; i < inputLists.size(); i++) {
            assertEquals(expectedOutputs[i], s.findMax(inputLists.get(i)), 
                "findMax failed for input: " + inputLists.get(i));
        }
    }
}
