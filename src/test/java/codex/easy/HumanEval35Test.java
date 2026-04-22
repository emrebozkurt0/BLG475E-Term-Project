package codex.easy;

import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval35Test {
    @ParameterizedTest
    @MethodSource("maxElementCases")
    public void testMaxElement(List<Integer> input, int expected) {
        HumanEval35 s = new HumanEval35();
        assertEquals(expected, s.maxElement(new ArrayList<>(input)));
    }

    private static Stream<Arguments> maxElementCases() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 3),
                Arguments.of(List.of(5, 3, -5, 2, -3, 3, 9, 0, 124, 1, -10), 124),
                Arguments.of(List.of(7, 7, 7), 7) // mutated edge case: identical elements
        );
    }
}