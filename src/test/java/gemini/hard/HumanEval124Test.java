package gemini.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HumanEval124Test {
    @Test
    public void testValidDates() {
        HumanEval124 s = new HumanEval124();
        // 31-day months (line 42)
        assertTrue(s.validDate("01-11-2000"));
        assertTrue(s.validDate("03-11-2000"));
        assertTrue(s.validDate("05-11-2000"));
        assertTrue(s.validDate("07-11-2000"));
        assertTrue(s.validDate("08-11-2000"));
        assertTrue(s.validDate("10-11-2000"));
        assertTrue(s.validDate("12-11-2000"));

        // 30-day months (line 46)
        assertTrue(s.validDate("04-12-2003"));
        assertTrue(s.validDate("06-04-2020"));
        assertTrue(s.validDate("09-04-2020"));
        assertTrue(s.validDate("11-04-2020"));

        // 29-day month
        assertTrue(s.validDate("02-15-2000"));
    }

    @Test
    public void testInvalidDatesNullOrEmpty() {
        HumanEval124 s = new HumanEval124();
        assertFalse(s.validDate(null));
        assertFalse(s.validDate(""));
    }

    @Test
    public void testInvalidDatesFormat() {
        HumanEval124 s = new HumanEval124();
        assertFalse(s.validDate("06/04/2020"));
        assertFalse(s.validDate("04122003"));
        assertFalse(s.validDate("20030412"));
        assertFalse(s.validDate("2003-04"));
        assertFalse(s.validDate("2003-04-12"));
        assertFalse(s.validDate("04-2003"));
    }

    @Test
    public void testInvalidDatesNumberFormat() {
        HumanEval124 s = new HumanEval124();
        assertFalse(s.validDate("aa-bb-cccc"));
    }

    @Test
    public void testInvalidDatesRanges() {
        HumanEval124 s = new HumanEval124();
        // Month < 1 and Month > 12
        assertFalse(s.validDate("00-15-2020"));
        assertFalse(s.validDate("13-15-2020"));

        // 31-day months (e.g., month 1)
        assertFalse(s.validDate("01-00-2020")); // day < 1
        assertFalse(s.validDate("01-32-2020")); // day > 31
        assertTrue(s.validDate("01-31-2020"));  // day == 31

        // 30-day months (e.g., month 4)
        assertFalse(s.validDate("04-00-2020")); // day < 1
        assertFalse(s.validDate("04-31-2020")); // day > 30
        assertTrue(s.validDate("04-30-2020"));  // day == 30

        // 29-day month (month 2)
        assertFalse(s.validDate("02-00-2020")); // day < 1
        assertFalse(s.validDate("02-30-2020")); // day > 29
        assertTrue(s.validDate("02-29-2020"));  // day == 29

        // Additional cases
        assertFalse(s.validDate("15-01-2012"));
        assertFalse(s.validDate("04-0-2040"));
        assertFalse(s.validDate("03-32-2011"));
        assertFalse(s.validDate("04-31-3000"));
        assertFalse(s.validDate("21-31-2000"));
        assertFalse(s.validDate("02-30-2000"));
    }
}
