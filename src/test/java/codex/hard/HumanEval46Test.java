package codex.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval46Test {

    @Test
    public void fib4_returnsZeroForDefinedZeroCases() {
        HumanEval46 solution = new HumanEval46();

        assertEquals(0, solution.fib4(0));
        assertEquals(0, solution.fib4(1));
        assertEquals(0, solution.fib4(3));
    }

    @Test
    public void fib4_returnsTwoForSecondIndex() {
        HumanEval46 solution = new HumanEval46();
        assertEquals(2, solution.fib4(2));
    }

    @Test
    public void fib4_computesCorrectValueAtLoopBoundary() {
        HumanEval46 solution = new HumanEval46();
        assertEquals(2, solution.fib4(4));
    }

    @Test
    public void fib4_computesKnownValuesForLargerInputs() {
        HumanEval46 solution = new HumanEval46();

        assertEquals(4, solution.fib4(5));
        assertEquals(28, solution.fib4(8));
        assertEquals(104, solution.fib4(10));
        assertEquals(386, solution.fib4(12));
    }
}
