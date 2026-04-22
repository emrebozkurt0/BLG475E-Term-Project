package gemini.easy;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval23Test {
    @ParameterizedTest
    @MethodSource("provideStrings")
    public void testStrlen(String input, int expected) {
        HumanEval23 s = new HumanEval23();
        int result = s.strlen(input);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideStrings() {
        return Stream.of(
            Arguments.of("", 0),
            Arguments.of("x", 1),
            Arguments.of("asdfgh", 6),
            Arguments.of("abc!?", 5) // mutated edge case: special characters
        );
    }

}
