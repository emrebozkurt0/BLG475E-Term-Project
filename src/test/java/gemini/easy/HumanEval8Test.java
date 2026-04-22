package gemini.easy;
import java.util.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class HumanEval8Test {
    @ParameterizedTest
    @MethodSource("provideLists")
    public void testSumProduct(List<Integer> input, List<Integer> expected) {
        HumanEval8 s = new HumanEval8();
        List<Integer> result = s.sumProduct(new ArrayList<>(input));
        assertEquals(expected, result);
    }
    private static java.util.stream.Stream<Arguments> provideLists() {
        return java.util.stream.Stream.of(
            Arguments.of(List.of(), Arrays.asList(0, 1)),
            Arguments.of(Arrays.asList(1, 1, 1), Arrays.asList(3, 1)),
            Arguments.of(Arrays.asList(100, 0), Arrays.asList(100, 0)),
            Arguments.of(Arrays.asList(3, 5, 7), Arrays.asList(15, 105)),
            Arguments.of(List.of(10), Arrays.asList(10, 10)),
            Arguments.of(Arrays.asList(-1, -2, -3), Arrays.asList(-6, -6)) // mutated edge case: negative numbers
        );
    }

}
