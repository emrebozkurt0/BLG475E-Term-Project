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
            org.junit.jupiter.params.provider.Arguments.of("yello", "ell", true, null),
            org.junit.jupiter.params.provider.Arguments.of("efef", "fee", true, null),
            org.junit.jupiter.params.provider.Arguments.of("winemtt", "tinem", true, null),
            org.junit.jupiter.params.provider.Arguments.of("hello", "ell", true, null),
            org.junit.jupiter.params.provider.Arguments.of("xyzw", "xyw", false, null),
            org.junit.jupiter.params.provider.Arguments.of("whattup", "ptut", false, null),
            org.junit.jupiter.params.provider.Arguments.of("abab", "aabb", false, null),
            org.junit.jupiter.params.provider.Arguments.of("anything", "", true, null),
            org.junit.jupiter.params.provider.Arguments.of("ab", "abcd", false, null),
            org.junit.jupiter.params.provider.Arguments.of(null, "ab", null, NullPointerException.class),
            org.junit.jupiter.params.provider.Arguments.of("ab", null, null, NullPointerException.class)
        );
    }

    private void executeCycpatternAssertion(HumanEval154 s, String a, String b, Boolean expected, Class<? extends Throwable> expectedException) {
        if (expectedException != null) {
            assertThrows(expectedException, () -> s.cycpatternCheck(a, b));
        } else {
            assertEquals((boolean) expected, s.cycpatternCheck(a, b), "cycpatternCheck outcome should match expected");
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideCycpatternData")
    public void testCycpatternCheckAll(String a, String b, Boolean expected, Class<? extends Throwable> expectedException) {
        HumanEval154 s = new HumanEval154();
        org.junit.jupiter.api.Assertions.assertNotNull(s);
        executeCycpatternAssertion(s, a, b, expected, expectedException);
    }
}
