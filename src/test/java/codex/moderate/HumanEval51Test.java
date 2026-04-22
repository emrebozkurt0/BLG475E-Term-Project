package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HumanEval51Test {
    static Stream<Arguments> removeVowelsCases() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("abcdef\nghijklm", "bcdf\nghjklm"),
                Arguments.of("fedcba", "fdcb"),
                Arguments.of("eeeee", ""),
                Arguments.of("acBAA", "cB"),
                Arguments.of("EcBOO", "cB"),
                Arguments.of("ybcd", "ybcd")
        );
    }

    @ParameterizedTest
    @MethodSource("removeVowelsCases")
    public void testRemoveVowels(String input, String expected) {
        HumanEval_51 s = new HumanEval_51();
        assertEquals(expected, s.removeVowels(input),
            "removeVowels should match expected for input=" + String.valueOf(input));
    }

    @Test
    public void mutationBoundaryCasesForRemoveVowels() {
        HumanEval_51 s = new HumanEval_51();
        String uppercaseOnlyVowels = "AEIOU";
        String vowelsSeparatedBySpaces = "a e i";
        String alphaNumericInput = "123 xyz";

        assertEquals("", s.removeVowels(uppercaseOnlyVowels),
            "all uppercase vowels should be removed");
        assertEquals("  ", s.removeVowels(vowelsSeparatedBySpaces),
            "vowels should be removed while preserving spaces");
        assertEquals("123 xyz", s.removeVowels(alphaNumericInput),
            "non-vowel characters should stay unchanged");
        assertThrows(NullPointerException.class, () -> s.removeVowels(null),
            "null input should throw NullPointerException");
    }
}