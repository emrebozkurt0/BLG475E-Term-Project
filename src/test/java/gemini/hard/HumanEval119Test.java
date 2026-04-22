package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval119Test {
    @Test
    public void testMatchParens() {
        HumanEval119 s = new HumanEval119();
        
        String[][] inputs = {
            {"()(", ")"},
            {")())", "(()()("},
            {"(())))", "(()())(("},
            {"(()(", "()))()"},
            {")", ")"},
            {"(()(())", "())())"},
            {"()", "())"},
            {"((((", "((())"},
            {")(()", "(()("},
            {")(", ")("},
            {"a", "b"}
        };
        
        String[] expectedOutputs = {
            "Yes", "Yes", "Yes", "Yes",
            "No", "No", "No", "No", "No", "No",
            "Yes"
        };

        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expectedOutputs[i], s.matchParens(Arrays.asList(inputs[i])), 
                "matchParens " + Arrays.toString(inputs[i]) + " should be " + expectedOutputs[i]);
        }
    }
}
