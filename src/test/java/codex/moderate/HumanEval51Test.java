package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
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
                Arguments.of("ybcd", "ybcd"),
                Arguments.of("AEIOU", ""),
                Arguments.of("a e i", "  "),
                Arguments.of("123 xyz", "123 xyz")
        );
    }

    @ParameterizedTest
    @MethodSource("removeVowelsCases")
    public void testRemoveVowels(String input, String expected) {
        HumanEval_51 s = new HumanEval_51();
        assertEquals(expected, s.removeVowels(input),
            "removeVowels should match expected for input=" + String.valueOf(input));
    }
}