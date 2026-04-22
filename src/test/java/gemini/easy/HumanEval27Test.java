package gemini.easy;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval27Test {
    @ParameterizedTest
    @MethodSource("provideStrings")
    public void testFlipCase(String input, String expected) {
        HumanEval27 s = new HumanEval27();
        String result = s.flipCase(input);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideStrings() {
        return Stream.of(
            Arguments.of("", ""),
            Arguments.of("Hello!", "hELLO!"),
            Arguments.of("These violent delights have violent ends", "tHESE VIOLENT DELIGHTS HAVE VIOLENT ENDS"),
            Arguments.of("123", "123") // mutated edge case: purely numerical strings
        );
    }

}
