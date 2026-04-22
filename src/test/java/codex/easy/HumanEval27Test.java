package codex.easy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval27Test {
    @ParameterizedTest
    @MethodSource("flipCaseCases")
    public void testFlipCase(String input, String expected) {
        HumanEval27 s = new HumanEval27();
        assertEquals(expected, s.flipCase(input));
    }

    private static Stream<Arguments> flipCaseCases() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("Hello!", "hELLO!"),
                Arguments.of("These violent delights have violent ends", "tHESE VIOLENT DELIGHTS HAVE VIOLENT ENDS")
        );
    }
}