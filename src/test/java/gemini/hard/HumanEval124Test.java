package gemini.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HumanEval124Test {
    static java.util.stream.Stream<String> provideValidDates() {
        return java.util.stream.Stream.of(
            "01-11-2000", "03-11-2000", "05-11-2000", "07-11-2000", 
            "08-11-2000", "10-11-2000", "12-11-2000", "01-31-2020",
            "04-12-2003", "06-04-2020", "09-04-2020", "11-04-2020", "04-30-2020",
            "02-15-2000", "02-29-2020"
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideValidDates")
    public void testValidDates(String date) {
        HumanEval124 s = new HumanEval124();
        assertTrue(s.validDate(date), "Date should be valid");
    }

    static java.util.stream.Stream<String> provideInvalidDates() {
        return java.util.stream.Stream.of(
            null, "", "06/04/2020", "04122003", "20030412", "2003-04", 
            "2003-04-12", "04-2003", "aa-bb-cccc", "00-15-2020", "13-15-2020",
            "01-00-2020", "01-32-2020", "04-00-2020", "04-31-2020",
            "02-00-2020", "02-30-2020", "15-01-2012", "04-0-2040",
            "03-32-2011", "04-31-3000", "21-31-2000", "02-30-2000"
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideInvalidDates")
    public void testInvalidDates(String date) {
        HumanEval124 s = new HumanEval124();
        assertFalse(s.validDate(date), "Date should be invalid");
    }
}
