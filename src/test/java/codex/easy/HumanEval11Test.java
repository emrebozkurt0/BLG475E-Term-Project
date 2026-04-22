package codex.easy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval11Test {
    @ParameterizedTest
    @MethodSource("stringXorCases")
    public void testStringXor(String left, String right, String expected) {
        HumanEval11 s = new HumanEval11();
        assertEquals(expected, s.stringXor(left, right));
    }

    private static Stream<Arguments> stringXorCases() {
        return Stream.of(
                Arguments.of("111000", "101010", "010010"),
                Arguments.of("1", "1", "0"),
                Arguments.of("0101", "0000", "0101")
        );
    }
}