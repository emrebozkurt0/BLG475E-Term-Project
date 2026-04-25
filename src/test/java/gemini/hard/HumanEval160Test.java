package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval160Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideAlgebraData() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("**", "*", "+"), Arrays.asList(2, 3, 4, 5), 37, null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("+", "*", "-"), Arrays.asList(2, 3, 4, 5), 9, null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("/", "*"), Arrays.asList(7, 3, 4), 8, null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("+", "**", "**"), Arrays.asList(7, 5, 3, 2), 1953132, null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("//"), Arrays.asList(7, 3), 2, null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("?"), Arrays.asList(2, 3), 2, null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("+"), Arrays.asList(1, 2), 3, null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList(), Arrays.asList(42), 42, null),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("+", "+"), Arrays.asList(1, 2), null, IndexOutOfBoundsException.class),
            org.junit.jupiter.params.provider.Arguments.of(Arrays.asList("/"), Arrays.asList(3, 0), null, ArithmeticException.class)
        );
    }

    private void executeAlgebraAssertion(HumanEval160 s, List<String> ops, List<Integer> nums, Integer expected, Class<? extends Throwable> expectedException) {
        if (expectedException != null) {
            assertThrows(expectedException, () -> s.doAlgebra(new ArrayList<>(ops), new ArrayList<>(nums)));
        } else {
            assertEquals((int) expected, s.doAlgebra(new ArrayList<>(ops), new ArrayList<>(nums)), "doAlgebra returned incorrect value");
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideAlgebraData")
    public void testDoAlgebra(List<String> ops, List<Integer> nums, Integer expected, Class<? extends Throwable> expectedException) {
        HumanEval160 s = new HumanEval160();
        org.junit.jupiter.api.Assertions.assertNotNull(s);
        executeAlgebraAssertion(s, ops, nums, expected, expectedException);
    }
}
