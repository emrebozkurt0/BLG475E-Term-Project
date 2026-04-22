package gemini.hard;

import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval154Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideCycpatternData() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of("yello", "ell", true),
            org.junit.jupiter.params.provider.Arguments.of("efef", "fee", true),
            org.junit.jupiter.params.provider.Arguments.of("winemtt", "tinem", true),
            org.junit.jupiter.params.provider.Arguments.of("hello", "ell", true),
            org.junit.jupiter.params.provider.Arguments.of("xyzw", "xyw", false),
            org.junit.jupiter.params.provider.Arguments.of("whattup", "ptut", false),
            org.junit.jupiter.params.provider.Arguments.of("abab", "aabb", false)
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideCycpatternData")
    public void testCycpatternCheckAll(String a, String b, boolean expected) {
        HumanEval154 s = new HumanEval154();
        assertEquals(expected, s.cycpatternCheck(a, b), "cycpatternCheck outcome should match expected");
    }
}
