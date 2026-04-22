package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
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
            "']]]]]]]]', false"
    })
    public void testIsNested(String input, boolean expected) {
        HumanEval_132 s = new HumanEval_132();
        assertEquals(expected, s.isNested(input),
            "isNested should match expected for input='" + input + "'");
    }

    @Test
    public void mutationBoundaryCasesForIsNested() {
        HumanEval_132 s = new HumanEval_132();
        String sequentialPairs = "[][][]";
        String nestedStructure = "[[][]]";
        String malformedOrder = "][][[";

        assertEquals(false, s.isNested(sequentialPairs),
            "sequential bracket pairs should not be nested");
        assertEquals(true, s.isNested(nestedStructure),
            "nested bracket structure should be detected as nested");
        assertEquals(false, s.isNested(malformedOrder),
            "malformed ordering should not be treated as nested");
        assertThrows(NullPointerException.class, () -> s.isNested(null),
            "null input should throw NullPointerException");
    }
}