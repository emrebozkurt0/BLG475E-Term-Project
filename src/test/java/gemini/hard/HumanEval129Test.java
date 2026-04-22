package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval129Test {
    @Test
    public void testMinPathAll() {
        HumanEval129 s = new HumanEval129();

        // Test 1
        List<List<Integer>> grid1 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        int k1 = 3;
        List<Integer> expected1 = Arrays.asList(1, 2, 1);
        assertEquals(expected1, s.minPath(grid1, k1), "Test 1 failed");

        // Test 2
        List<List<Integer>> grid2 = Arrays.asList(
                Arrays.asList(5, 9, 3),
                Arrays.asList(4, 1, 6),
                Arrays.asList(7, 8, 2)
        );
        int k2 = 1;
        List<Integer> expected2 = List.of(1);
        assertEquals(expected2, s.minPath(grid2, k2), "Test 2 failed");

        // Test 3
        List<List<Integer>> grid3 = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16)
        );
        int k3 = 4;
        List<Integer> expected3 = Arrays.asList(1, 2, 1, 2);
        assertEquals(expected3, s.minPath(grid3, k3), "Test 3 failed");

        // Test 4
        List<List<Integer>> grid4 = Arrays.asList(
                Arrays.asList(6, 4, 13, 10),
                Arrays.asList(5, 7, 12, 1),
                Arrays.asList(3, 16, 11, 15),
                Arrays.asList(8, 14, 9, 2)
        );
        int k4 = 7;
        List<Integer> expected4 = Arrays.asList(1, 10, 1, 10, 1, 10, 1);
        assertEquals(expected4, s.minPath(grid4, k4), "Test 4 failed");

        // Test 5
        List<List<Integer>> grid5 = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 2));
        int k5 = 10;
        List<Integer> expected5 = Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3, 1, 3);
        assertEquals(expected5, s.minPath(grid5, k5), "Test 5 failed");

        // Corner
        List<List<Integer>> gridCorner = Arrays.asList(Arrays.asList(2, 3), Arrays.asList(4, 1));
        int kCorner = 3;
        List<Integer> expectedCorner = Arrays.asList(1, 3, 1);
        assertEquals(expectedCorner, s.minPath(gridCorner, kCorner), "Corner failed");

        // No One
        List<List<Integer>> gridNoOne = Arrays.asList(Arrays.asList(2, 3), Arrays.asList(4, 5));
        int kNoOne = 2;
        List<Integer> expectedNoOne = Arrays.asList(1, Integer.MAX_VALUE);
        assertEquals(expectedNoOne, s.minPath(gridNoOne, kNoOne), "NoOne failed");

        // Empty
        List<List<Integer>> gridEmpty = Arrays.asList();
        int kEmpty = 2;
        List<Integer> expectedEmpty = Arrays.asList(1, Integer.MAX_VALUE);
        assertEquals(expectedEmpty, s.minPath(gridEmpty, kEmpty), "Empty failed");
    }
}
