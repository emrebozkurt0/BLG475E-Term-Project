package gemini.hard;

import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval124Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideDateData() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of("01-11-2000", true),
            org.junit.jupiter.params.provider.Arguments.of("03-11-2000", true),
            org.junit.jupiter.params.provider.Arguments.of("05-11-2000", true),
            org.junit.jupiter.params.provider.Arguments.of("07-11-2000", true),
            org.junit.jupiter.params.provider.Arguments.of("08-11-2000", true),
            org.junit.jupiter.params.provider.Arguments.of("10-11-2000", true),
            org.junit.jupiter.params.provider.Arguments.of("12-11-2000", true),
            org.junit.jupiter.params.provider.Arguments.of("01-31-2020", true),
            org.junit.jupiter.params.provider.Arguments.of("04-12-2003", true),
            org.junit.jupiter.params.provider.Arguments.of("06-04-2020", true),
            org.junit.jupiter.params.provider.Arguments.of("09-04-2020", true),
            org.junit.jupiter.params.provider.Arguments.of("11-04-2020", true),
            org.junit.jupiter.params.provider.Arguments.of("04-30-2020", true),
            org.junit.jupiter.params.provider.Arguments.of("02-15-2000", true),
            org.junit.jupiter.params.provider.Arguments.of("02-29-2020", true),

            org.junit.jupiter.params.provider.Arguments.of(null, false),
            org.junit.jupiter.params.provider.Arguments.of("", false),
            org.junit.jupiter.params.provider.Arguments.of("06/04/2020", false),
            org.junit.jupiter.params.provider.Arguments.of("04122003", false),
            org.junit.jupiter.params.provider.Arguments.of("20030412", false),
            org.junit.jupiter.params.provider.Arguments.of("2003-04", false),
            org.junit.jupiter.params.provider.Arguments.of("2003-04-12", false),
            org.junit.jupiter.params.provider.Arguments.of("04-2003", false),
            org.junit.jupiter.params.provider.Arguments.of("aa-bb-cccc", false),
            org.junit.jupiter.params.provider.Arguments.of("00-15-2020", false),
            org.junit.jupiter.params.provider.Arguments.of("13-15-2020", false),
            org.junit.jupiter.params.provider.Arguments.of("01-00-2020", false),
            org.junit.jupiter.params.provider.Arguments.of("01-32-2020", false),
            org.junit.jupiter.params.provider.Arguments.of("04-00-2020", false),
            org.junit.jupiter.params.provider.Arguments.of("04-31-2020", false),
            org.junit.jupiter.params.provider.Arguments.of("02-00-2020", false),
            org.junit.jupiter.params.provider.Arguments.of("02-30-2020", false),
            org.junit.jupiter.params.provider.Arguments.of("15-01-2012", false),
            org.junit.jupiter.params.provider.Arguments.of("04-0-2040", false),
            org.junit.jupiter.params.provider.Arguments.of("03-32-2011", false),
            org.junit.jupiter.params.provider.Arguments.of("04-31-3000", false),
            org.junit.jupiter.params.provider.Arguments.of("21-31-2000", false),
            org.junit.jupiter.params.provider.Arguments.of("02-30-2000", false)
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideDateData")
    public void testValidDateAll(String date, boolean expected) {
        HumanEval124 s = new HumanEval124();
        assertEquals(expected, s.validDate(date), "validDate outcome should match expected");
    }
}
