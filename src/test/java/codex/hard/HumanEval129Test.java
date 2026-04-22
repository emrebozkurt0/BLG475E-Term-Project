package codex.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval129Test {

    @Test
    public void minPath_returnsExpectedPattern_forSampleCaseOne() {
        HumanEval129 solution = new HumanEval129();
        List<Integer> result = solution.minPath(
                Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)),
                3
        );
        assertEquals(Arrays.asList(1, 2, 1), result);
    }

    @Test
    public void minPath_returnsSingleOne_whenKIsOne() {
        HumanEval129 solution = new HumanEval129();
        List<Integer> result = solution.minPath(
                Arrays.asList(Arrays.asList(5, 9, 3), Arrays.asList(4, 1, 6), Arrays.asList(7, 8, 2)),
                1
        );
        assertEquals(List.of(1), result);
    }

    @Test
    public void minPath_handlesTopLeftOne_withAlternatingBestNeighbor() {
        HumanEval129 solution = new HumanEval129();
        List<Integer> result = solution.minPath(
                Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8), Arrays.asList(9, 10, 11, 12), Arrays.asList(13, 14, 15, 16)),
                4
        );
        assertEquals(Arrays.asList(1, 2, 1, 2), result);
    }

    @Test
    public void minPath_handlesRightEdgeOne() {
        HumanEval129 solution = new HumanEval129();
        List<Integer> result = solution.minPath(
                Arrays.asList(Arrays.asList(6, 4, 13, 10), Arrays.asList(5, 7, 12, 1), Arrays.asList(3, 16, 11, 15), Arrays.asList(8, 14, 9, 2)),
                7
        );
        assertEquals(Arrays.asList(1, 10, 1, 10, 1, 10, 1), result);
    }

    @Test
    public void minPath_handlesInteriorOne_withAllFourNeighbors() {
        HumanEval129 solution = new HumanEval129();
        List<Integer> result = solution.minPath(
                Arrays.asList(Arrays.asList(8, 14, 9, 2), Arrays.asList(6, 4, 13, 15), Arrays.asList(5, 7, 1, 12), Arrays.asList(3, 10, 11, 16)),
                5
        );
        assertEquals(Arrays.asList(1, 7, 1, 7, 1), result);
    }

    @Test
    public void minPath_handlesBottomRightOne_withLongOddK() {
        HumanEval129 solution = new HumanEval129();
        List<Integer> result = solution.minPath(
                Arrays.asList(Arrays.asList(11, 8, 7, 2), Arrays.asList(5, 16, 14, 4), Arrays.asList(9, 3, 15, 6), Arrays.asList(12, 13, 10, 1)),
                9
        );
        assertEquals(Arrays.asList(1, 6, 1, 6, 1, 6, 1, 6, 1), result);
    }

    @Test
    public void minPath_handlesTopRightOne_withLongEvenK() {
        HumanEval129 solution = new HumanEval129();
        List<Integer> result = solution.minPath(
                Arrays.asList(Arrays.asList(12, 13, 10, 1), Arrays.asList(9, 3, 15, 6), Arrays.asList(5, 16, 14, 4), Arrays.asList(11, 8, 7, 2)),
                12
        );
        assertEquals(Arrays.asList(1, 6, 1, 6, 1, 6, 1, 6, 1, 6, 1, 6), result);
    }

    @Test
    public void minPath_handlesCenterOne_withBestNeighborThree() {
        HumanEval129 solution = new HumanEval129();
        List<Integer> result = solution.minPath(
                Arrays.asList(Arrays.asList(2, 7, 4), Arrays.asList(3, 1, 5), Arrays.asList(6, 8, 9)),
                8
        );
        assertEquals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3), result);
    }

    @Test
    public void minPath_handlesTopMiddleOne_withBestNeighborFive() {
        HumanEval129 solution = new HumanEval129();
        List<Integer> result = solution.minPath(
                Arrays.asList(Arrays.asList(6, 1, 5), Arrays.asList(3, 8, 9), Arrays.asList(2, 7, 4)),
                8
        );
        assertEquals(Arrays.asList(1, 5, 1, 5, 1, 5, 1, 5), result);
    }

    @Test
    public void minPath_handlesTwoByTwoGrid_caseOne() {
        HumanEval129 solution = new HumanEval129();
        List<Integer> result = solution.minPath(
                Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4)),
                10
        );
        assertEquals(Arrays.asList(1, 2, 1, 2, 1, 2, 1, 2, 1, 2), result);
    }

    @Test
    public void minPath_handlesTwoByTwoGrid_caseTwo() {
        HumanEval129 solution = new HumanEval129();
        List<Integer> result = solution.minPath(
                Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 2)),
                10
        );
        assertEquals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3, 1, 3), result);
    }

    @Test
    public void minPath_returnsEmptyList_forEmptyGridAndZeroK() {
        HumanEval129 solution = new HumanEval129();
        List<Integer> result = solution.minPath(List.of(), 0);

        assertEquals(List.of(), result);
    }
}
