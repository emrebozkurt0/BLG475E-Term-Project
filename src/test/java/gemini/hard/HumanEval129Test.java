package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval129Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideMinPathData() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)), 3, Arrays.asList(1, 2, 1)),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(Arrays.asList(5, 9, 3), Arrays.asList(4, 1, 6), Arrays.asList(7, 8, 2)), 1, List.of(1)),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8), Arrays.asList(9, 10, 11, 12), Arrays.asList(13, 14, 15, 16)), 4, Arrays.asList(1, 2, 1, 2)),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(Arrays.asList(6, 4, 13, 10), Arrays.asList(5, 7, 12, 1), Arrays.asList(3, 16, 11, 15), Arrays.asList(8, 14, 9, 2)), 7, Arrays.asList(1, 10, 1, 10, 1, 10, 1)),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 2)), 10, Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3, 1, 3)),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(Arrays.asList(2, 3), Arrays.asList(4, 1)), 3, Arrays.asList(1, 3, 1)),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(Arrays.asList(2, 3), Arrays.asList(4, 5)), 2, Arrays.asList(1, Integer.MAX_VALUE)),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(), 2, Arrays.asList(1, Integer.MAX_VALUE))
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideMinPathData")
    public void testMinPathAll(List<List<Integer>> grid, int k, List<Integer> expected) {
        HumanEval129 s = new HumanEval129();
        assertEquals(expected, s.minPath(grid, k), "minPath returned incorrect value");
    }
}
