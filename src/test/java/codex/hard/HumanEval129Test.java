package codex.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval129Test {

    @ParameterizedTest(name = "minPath case {index}")
    @MethodSource("minPathCases")
    public void minPath_returnsExpectedPattern(List<List<Integer>> grid, int k, List<Integer> expected) {
        HumanEval129 solution = new HumanEval129();
        assertEquals(expected, solution.minPath(grid, k));
    }

    private static Stream<Arguments> minPathCases() {
        return Stream.of(
                Arguments.of(grid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}), 3, list(1, 2, 1)),
                Arguments.of(grid(new int[][]{{5, 9, 3}, {4, 1, 6}, {7, 8, 2}}), 1, list(1)),
                Arguments.of(grid(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}), 4, list(1, 2, 1, 2)),
                Arguments.of(grid(new int[][]{{6, 4, 13, 10}, {5, 7, 12, 1}, {3, 16, 11, 15}, {8, 14, 9, 2}}), 7, list(1, 10, 1, 10, 1, 10, 1)),
                Arguments.of(grid(new int[][]{{8, 14, 9, 2}, {6, 4, 13, 15}, {5, 7, 1, 12}, {3, 10, 11, 16}}), 5, list(1, 7, 1, 7, 1)),
                Arguments.of(grid(new int[][]{{11, 8, 7, 2}, {5, 16, 14, 4}, {9, 3, 15, 6}, {12, 13, 10, 1}}), 9, list(1, 6, 1, 6, 1, 6, 1, 6, 1)),
                Arguments.of(grid(new int[][]{{12, 13, 10, 1}, {9, 3, 15, 6}, {5, 16, 14, 4}, {11, 8, 7, 2}}), 12, list(1, 6, 1, 6, 1, 6, 1, 6, 1, 6, 1, 6)),
                Arguments.of(grid(new int[][]{{2, 7, 4}, {3, 1, 5}, {6, 8, 9}}), 8, list(1, 3, 1, 3, 1, 3, 1, 3)),
                Arguments.of(grid(new int[][]{{6, 1, 5}, {3, 8, 9}, {2, 7, 4}}), 8, list(1, 5, 1, 5, 1, 5, 1, 5)),
                Arguments.of(grid(new int[][]{{1, 2}, {3, 4}}), 10, list(1, 2, 1, 2, 1, 2, 1, 2, 1, 2)),
                Arguments.of(grid(new int[][]{{1, 3}, {3, 2}}), 10, list(1, 3, 1, 3, 1, 3, 1, 3, 1, 3)),
                // Mutation tests for uncovered ECs: EC9 (invalid grid N=1)
                Arguments.of(grid(new int[][]{{1}}), 3, list(1, Integer.MAX_VALUE, 1)),
                Arguments.of(grid(new int[][]{}), 0, List.of())
        );
    }

    @ParameterizedTest(name = "minPath invalid case {index}")
    @MethodSource("invalidMinPathCases")
    public void minPath_invalidInput_throwsExpectedException(List<List<Integer>> grid, int k, Class<? extends Throwable> expectedException) {
        HumanEval129 solution = new HumanEval129();
        assertThrows(expectedException, () -> solution.minPath(grid, k));
    }

    private static Stream<Arguments> invalidMinPathCases() {
        return Stream.of(
                // Mutation tests for uncovered ECs: EC9 (invalid permutation/content)
                Arguments.of(grid(new int[][]{{2, 3}, {4, 5}}), 3, IndexOutOfBoundsException.class),
                // Mutation tests for uncovered ECs: EC9 (non-square grid)
                Arguments.of(Arrays.asList(Arrays.asList(1, 2), List.of()), 3, IndexOutOfBoundsException.class)
        );
    }

    private static List<List<Integer>> grid(int[][] values) {
        return Arrays.stream(values)
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private static List<Integer> list(int... values) {
        return Arrays.stream(values).boxed().collect(Collectors.toList());
    }
}
