package codex.easy;

import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval28Test {
    @ParameterizedTest
    @MethodSource("concatenateCases")
    public void testConcatenate(List<String> input, String expected) {
        HumanEval28 s = new HumanEval28();
        assertEquals(expected, s.concatenate(new ArrayList<>(input)));
    }

    private static Stream<Arguments> concatenateCases() {
        return Stream.of(
                Arguments.of(List.of(), ""),
                Arguments.of(List.of("x", "y", "z"), "xyz"),
                Arguments.of(List.of("x", "y", "z", "w", "k"), "xyzwk")
        );
    }
}