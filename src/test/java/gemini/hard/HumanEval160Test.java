package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval160Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideAlgebraData() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("**", "*", "+")), new ArrayList<>(Arrays.asList(2, 3, 4, 5)), 37),
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("+", "*", "-")), new ArrayList<>(Arrays.asList(2, 3, 4, 5)), 9),
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("/", "*")), new ArrayList<>(Arrays.asList(7, 3, 4)), 8),
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("+", "**", "**")), new ArrayList<>(Arrays.asList(7, 5, 3, 2)), 1953132),
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("//")), new ArrayList<>(Arrays.asList(7, 3)), 2),
            org.junit.jupiter.params.provider.Arguments.of(new ArrayList<>(Arrays.asList("?")), new ArrayList<>(Arrays.asList(2, 3)), 2)
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideAlgebraData")
    public void testDoAlgebra(ArrayList<String> ops, ArrayList<Integer> nums, int expected) {
        HumanEval160 s = new HumanEval160();
        assertEquals(expected, s.doAlgebra(ops, nums), "doAlgebra returned incorrect value");
    }
}
