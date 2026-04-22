package codex.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval154Test {

    @ParameterizedTest(name = "cycpatternCheck case {index}")
    @MethodSource("cycpatternCases")
    public void cycpatternCheck_returnsExpectedResult(String a, String b, boolean expected) {
        HumanEval154 solution = new HumanEval154();
        assertEquals(expected, solution.cycpatternCheck(a, b));
    }

    private static Stream<Arguments> cycpatternCases() {
        return Stream.of(
                Arguments.of("xyzw", "xyw", false),
                Arguments.of("yello", "ell", true),
                Arguments.of("whattup", "ptut", false),
                Arguments.of("efef", "fee", true),
                Arguments.of("abab", "aabb", false),
                Arguments.of("winemtt", "tinem", true),
                Arguments.of("anything", "", true),
                Arguments.of("ab", "abcd", false),
                Arguments.of("zzcabyy", "abc", true)
        );
    }
}
