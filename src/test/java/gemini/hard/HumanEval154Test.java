package gemini.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HumanEval154Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideTrueCases() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of("yello", "ell"),
            org.junit.jupiter.params.provider.Arguments.of("efef", "fee"),
            org.junit.jupiter.params.provider.Arguments.of("winemtt", "tinem"),
            org.junit.jupiter.params.provider.Arguments.of("hello", "ell")
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideTrueCases")
    public void testCycpatternCheckTrue(String a, String b) {
        HumanEval154 s = new HumanEval154();
        assertTrue(s.cycpatternCheck(a, b), "cycpatternCheck should return true");
    }

    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideFalseCases() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of("xyzw", "xyw"),
            org.junit.jupiter.params.provider.Arguments.of("whattup", "ptut"),
            org.junit.jupiter.params.provider.Arguments.of("abab", "aabb")
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideFalseCases")
    public void testCycpatternCheckFalse(String a, String b) {
        HumanEval154 s = new HumanEval154();
        assertFalse(s.cycpatternCheck(a, b), "cycpatternCheck should return false");
    }
}
