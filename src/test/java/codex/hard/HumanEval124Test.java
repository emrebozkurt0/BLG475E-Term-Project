package codex.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HumanEval124Test {

    @Test
    public void validDate_rejectsNullEmptyAndWrongStructure() {
        HumanEval124 solution = new HumanEval124();

        assertFalse(solution.validDate(null));
        assertFalse(solution.validDate(""));
        assertFalse(solution.validDate("06/04/2020"));
        assertFalse(solution.validDate("04122003"));
        assertFalse(solution.validDate("20030412"));
        assertFalse(solution.validDate("2003-04"));
        assertFalse(solution.validDate("2003-04-12"));
        assertFalse(solution.validDate("04-2003"));
    }

    @Test
    public void validDate_rejectsInvalidTokenLengthsAndNonNumericParts() {
        HumanEval124 solution = new HumanEval124();

        assertFalse(solution.validDate("4-12-2003"));
        assertFalse(solution.validDate("04-1-2003"));
        assertFalse(solution.validDate("04-12-203"));
        assertFalse(solution.validDate("aa-12-2003"));
        assertFalse(solution.validDate("04-bb-2003"));
        assertFalse(solution.validDate("04-12-zzzz"));
    }

    @Test
    public void validDate_rejectsOutOfRangeMonthAndDayValues() {
        HumanEval124 solution = new HumanEval124();

        assertFalse(solution.validDate("00-10-2000"));
        assertFalse(solution.validDate("13-10-2000"));
        assertFalse(solution.validDate("04-00-2000"));
        assertFalse(solution.validDate("03-32-2011"));
        assertFalse(solution.validDate("21-31-2000"));
    }

    @Test
    public void validDate_handlesFebruaryBranch() {
        HumanEval124 solution = new HumanEval124();

        assertTrue(solution.validDate("02-29-2020"));
        assertFalse(solution.validDate("02-30-2020"));
    }

    @Test
    public void validDate_handlesThirtyDayMonths() {
        HumanEval124 solution = new HumanEval124();

        assertTrue(solution.validDate("04-12-2003"));
        assertTrue(solution.validDate("06-04-2020"));
        assertTrue(solution.validDate("09-30-2001"));
        assertTrue(solution.validDate("11-30-2001"));
        assertTrue(solution.validDate("06-06-2005"));
        assertFalse(solution.validDate("04-31-3000"));
        assertFalse(solution.validDate("09-31-3000"));
        assertFalse(solution.validDate("11-31-3000"));
    }

    @Test
    public void validDate_handlesThirtyOneDayMonths() {
        HumanEval124 solution = new HumanEval124();

        assertTrue(solution.validDate("03-11-2000"));
        assertFalse(solution.validDate("03-32-2000"));
    }
}
