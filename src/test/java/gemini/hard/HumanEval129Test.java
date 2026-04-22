package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval129Test {
    @Test
    public void testMinPath1() {
        HumanEval129 s = new HumanEval129();
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        assertEquals(Arrays.asList(1, 2, 1), s.minPath(grid, 3));
    }

    @Test
    public void testMinPath2() {
        HumanEval129 s = new HumanEval129();
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(5, 9, 3),
                Arrays.asList(4, 1, 6),
                Arrays.asList(7, 8, 2)
        );
        assertEquals(List.of(1), s.minPath(grid, 1));
    }

    @Test
    public void testMinPath3() {
        HumanEval129 s = new HumanEval129();
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16)
        );
        assertEquals(Arrays.asList(1, 2, 1, 2), s.minPath(grid, 4));
    }

    @Test
    public void testMinPath4() {
        HumanEval129 s = new HumanEval129();
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(6, 4, 13, 10),
                Arrays.asList(5, 7, 12, 1),
                Arrays.asList(3, 16, 11, 15),
                Arrays.asList(8, 14, 9, 2)
        );
        assertEquals(Arrays.asList(1, 10, 1, 10, 1, 10, 1), s.minPath(grid, 7));
    }

    @Test
    public void testMinPath5() {
        HumanEval129 s = new HumanEval129();
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 2)
        );
        assertEquals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3, 1, 3), s.minPath(grid, 10));
    }

    @Test
    public void testMinPathCorner() {
        HumanEval129 s = new HumanEval129();
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(2, 3),
                Arrays.asList(4, 1)
        );
        assertEquals(Arrays.asList(1, 3, 1), s.minPath(grid, 3));
    }

    @Test
    public void testMinPathNoOne() {
        HumanEval129 s = new HumanEval129();
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(2, 3),
                Arrays.asList(4, 5)
        );
        assertEquals(Arrays.asList(1, Integer.MAX_VALUE), s.minPath(grid, 2));
    }

    @Test
    public void testMinPathEmpty() {
        HumanEval129 s = new HumanEval129();
        List<List<Integer>> grid = Arrays.asList();
        assertEquals(Arrays.asList(1, Integer.MAX_VALUE), s.minPath(grid, 2));
    }
}
