package codex.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval160Test {

    @Test
    public void doAlgebra_matchesReferenceExamples() {
        HumanEval160 solution = new HumanEval160();

        assertEquals(37, solution.doAlgebra(new ArrayList<>(Arrays.asList("**", "*", "+")), new ArrayList<>(Arrays.asList(2, 3, 4, 5))));
        assertEquals(9, solution.doAlgebra(new ArrayList<>(Arrays.asList("+", "*", "-")), new ArrayList<>(Arrays.asList(2, 3, 4, 5))));
        assertEquals(8, solution.doAlgebra(new ArrayList<>(Arrays.asList("/", "*")), new ArrayList<>(Arrays.asList(7, 3, 4))));
        assertEquals(1953132, solution.doAlgebra(new ArrayList<>(Arrays.asList("+", "**", "**")), new ArrayList<>(Arrays.asList(7, 5, 3, 2))));
    }

    @Test
    public void doAlgebra_skipsOperatorLoopsWhenNoOperatorsExist() {
        HumanEval160 solution = new HumanEval160();

        assertEquals(42, solution.doAlgebra(new ArrayList<>(), new ArrayList<>(Arrays.asList(42))));
    }

    @Test
    public void doAlgebra_appliesMultiplicationAndDivisionLeftToRight() {
        HumanEval160 solution = new HumanEval160();

        assertEquals(15, solution.doAlgebra(new ArrayList<>(Arrays.asList("*", "/")), new ArrayList<>(Arrays.asList(10, 3, 2))));
    }

    @Test
    public void doAlgebra_appliesAdditionAndSubtractionLeftToRight() {
        HumanEval160 solution = new HumanEval160();

        assertEquals(4, solution.doAlgebra(new ArrayList<>(Arrays.asList("-", "+", "-")), new ArrayList<>(Arrays.asList(10, 3, 2, 5))));
    }

    @Test
    public void doAlgebra_handlesExponentiationBeforeOtherOperators() {
        HumanEval160 solution = new HumanEval160();

        assertEquals(17, solution.doAlgebra(new ArrayList<>(Arrays.asList("+", "**")), new ArrayList<>(Arrays.asList(8, 3, 2))));
    }

    @Test
    public void doAlgebra_leavesValueWhenUnsupportedOperatorReachesFinalPass() {
        HumanEval160 solution = new HumanEval160();

        assertEquals(9, solution.doAlgebra(new ArrayList<>(Arrays.asList("%")), new ArrayList<>(Arrays.asList(9, 4))));
    }
}
