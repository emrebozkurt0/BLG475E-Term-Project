package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HumanEval132Test {
    @ParameterizedTest
    @CsvSource({
            "'a', false",
            "'[[]]', true",
            "'[]]]]]]][[[[[]', false",
            "'[][]', false",
            "'[]', false",
            "'[[[[]]]]', true",
            "'[]]]]]]]]]]', false",
            "'[][][[]]', true",
            "'[[]', false",
            "'[]]', false",
            "'[[]][[', true",
            "'[[][]]', true",
            "'', false",
            "'[[[[[[[[', false",
                "']]]]]]]]', false",
                "'[][][]', false",
                "'][][[', false"
    })
    public void testIsNested(String input, boolean expected) {
        HumanEval_132 s = new HumanEval_132();
        assertEquals(expected, s.isNested(input),
            "isNested should match expected for input='" + input + "'");
    }
}