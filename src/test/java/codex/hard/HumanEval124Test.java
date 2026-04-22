package codex.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval124Test {

    @ParameterizedTest(name = "validDate case {index}")
    @MethodSource("validDateCases")
    public void validDate_returnsExpectedResult(String date, boolean expected) {
        HumanEval124 solution = new HumanEval124();
        assertEquals(expected, solution.validDate(date));
    }

    private static Stream<Arguments> validDateCases() {
        return Stream.of(
                Arguments.of((String) null, false),
                Arguments.of("", false),
                Arguments.of("06/04/2020", false),
                Arguments.of("04122003", false),
                Arguments.of("20030412", false),
                Arguments.of("2003-04", false),
                Arguments.of("2003-04-12", false),
                Arguments.of("04-2003", false),
                Arguments.of("4-12-2003", false),
                Arguments.of("04-1-2003", false),
                Arguments.of("04-12-203", false),
                Arguments.of("aa-12-2003", false),
                Arguments.of("04-bb-2003", false),
                Arguments.of("04-12-zzzz", false),
                Arguments.of("00-10-2000", false),
                Arguments.of("13-10-2000", false),
                Arguments.of("04-00-2000", false),
                Arguments.of("03-32-2011", false),
                Arguments.of("21-31-2000", false),
                Arguments.of("02-29-2020", true),
                Arguments.of("02-30-2020", false),
                Arguments.of("04-12-2003", true),
                Arguments.of("06-04-2020", true),
                Arguments.of("09-30-2001", true),
                Arguments.of("11-30-2001", true),
                Arguments.of("06-06-2005", true),
                Arguments.of("04-31-3000", false),
                Arguments.of("09-31-3000", false),
                Arguments.of("11-31-3000", false),
                Arguments.of("03-11-2000", true),
                Arguments.of("03-32-2000", false)
        );
    }
}
