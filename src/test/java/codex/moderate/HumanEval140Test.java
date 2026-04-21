package codex.moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HumanEval140Test {
    static Stream<Arguments> fixSpacesCases() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("Example", "Example"),
                Arguments.of("Mudasir Hanif ", "Mudasir_Hanif_"),
                Arguments.of("Example   ", "Example-"),
                Arguments.of("Yellow Yellow  Dirty  Fellow", "Yellow_Yellow__Dirty__Fellow"),
                Arguments.of("Exa   mple", "Exa-mple"),
                Arguments.of("   Exa 1 2 2 mple", "-Exa_1_2_2_mple")
        );
    }

    @ParameterizedTest
    @MethodSource("fixSpacesCases")
    public void testFixSpaces(String input, String expected) {
        HumanEval_140 s = new HumanEval_140();
        assertEquals(expected, s.fixSpaces(input));
    }
}