package codex.easy;

import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval8Test {
    @ParameterizedTest
    @MethodSource("sumProductCases")
    public void testSumProduct(List<Integer> input, List<Integer> expected) {
        HumanEval8 s = new HumanEval8();
        assertEquals(expected, s.sumProduct(new ArrayList<>(input)));
    }

    private static Stream<Arguments> sumProductCases() {
        return Stream.of(
                Arguments.of(List.of(), List.of(0, 1)),
                Arguments.of(List.of(1, 1, 1), List.of(3, 1)),
                Arguments.of(List.of(100, 0), List.of(100, 0)),
                Arguments.of(List.of(3, 5, 7), List.of(15, 105)),
                Arguments.of(List.of(10), List.of(10, 10)),
                Arguments.of(List.of(-1, -2, -3), List.of(-6, -6)) // mutated edge case: negative numbers
        );
    }
}