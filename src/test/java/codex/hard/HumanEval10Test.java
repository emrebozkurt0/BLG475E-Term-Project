package codex.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval10Test {

    @ParameterizedTest(name = "makePalindrome({0}) -> {1}")
    @MethodSource("makePalindromeCases")
    public void makePalindrome_returnsExpectedValue(String input, String expected) {
        HumanEval10 solution = new HumanEval10();
        assertEquals(expected, solution.makePalindrome(input));
    }

    private static Stream<Arguments> makePalindromeCases() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("x", "x"),
                Arguments.of("xyz", "xyzyx"),
                Arguments.of("xyx", "xyx"),
                Arguments.of("jerry", "jerryrrej")
        );
    }
}
