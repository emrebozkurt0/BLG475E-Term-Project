package gemini.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HumanEval124Test {
    @Test
    public void testValidDate() {
        HumanEval124 s = new HumanEval124();

        String[] validDates = {
            // 31-day months
            "01-11-2000", "03-11-2000", "05-11-2000", "07-11-2000", 
            "08-11-2000", "10-11-2000", "12-11-2000", "01-31-2020",
            // 30-day months
            "04-12-2003", "06-04-2020", "09-04-2020", "11-04-2020", "04-30-2020",
            // 29-day month
            "02-15-2000", "02-29-2020"
        };

        for (String date : validDates) {
            assertTrue(s.validDate(date), "Date " + date + " should be valid");
        }

        String[] invalidDates = {
            null, "", "06/04/2020", "04122003", "20030412", "2003-04", 
            "2003-04-12", "04-2003", "aa-bb-cccc", "00-15-2020", "13-15-2020",
            "01-00-2020", "01-32-2020", "04-00-2020", "04-31-2020",
            "02-00-2020", "02-30-2020", "15-01-2012", "04-0-2040",
            "03-32-2011", "04-31-3000", "21-31-2000", "02-30-2000"
        };

        for (String date : invalidDates) {
            assertFalse(s.validDate(date), "Date " + date + " should be invalid");
        }
    }
}
