package codex.easy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval23Test {
    @ParameterizedTest
    @MethodSource("strlenCases")
    public void testStrlen(String input, int expected) {
        HumanEval23 s = new HumanEval23();
        assertEquals(expected, s.strlen(input));
    }

    private static Stream<Arguments> strlenCases() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("x", 1),
                Arguments.of("asdfgh", 6)
        );
    }
}