package gemini.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval154Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideCycpatternData() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of("yello", "ell", true),
            org.junit.jupiter.params.provider.Arguments.of("efef", "fee", true),
            org.junit.jupiter.params.provider.Arguments.of("winemtt", "tinem", true),
            org.junit.jupiter.params.provider.Arguments.of("hello", "ell", true),
            org.junit.jupiter.params.provider.Arguments.of("xyzw", "xyw", false),
            org.junit.jupiter.params.provider.Arguments.of("whattup", "ptut", false),
            org.junit.jupiter.params.provider.Arguments.of("abab", "aabb", false),
            // Mutation tests for uncovered ECs: EC4 (empty pattern)
            org.junit.jupiter.params.provider.Arguments.of("anything", "", true),
            // Mutation tests for uncovered ECs: EC5 (|b| > |a|)
            org.junit.jupiter.params.provider.Arguments.of("ab", "abcd", false)
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideCycpatternData")
    public void testCycpatternCheckAll(String a, String b, boolean expected) {
        HumanEval154 s = new HumanEval154();
        assertEquals(expected, s.cycpatternCheck(a, b), "cycpatternCheck outcome should match expected");
    }

    static Stream<Arguments> provideInvalidCycpatternData() {
        return Stream.of(
            // Mutation tests for uncovered ECs: EC6 (null input)
            Arguments.of(null, "ab", NullPointerException.class),
            Arguments.of("ab", null, NullPointerException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidCycpatternData")
    public void testCycpatternInvalidInputs(String a, String b, Class<? extends Throwable> expectedException) {
        HumanEval154 s = new HumanEval154();
        assertThrows(expectedException, () -> s.cycpatternCheck(a, b));
    }
}
