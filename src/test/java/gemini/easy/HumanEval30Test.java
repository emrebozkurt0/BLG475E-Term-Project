package gemini.easy;
import java.util.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class HumanEval30Test {
    @ParameterizedTest
    @MethodSource("provideLists")
    public void testGetPositive(List<Integer> input, List<Integer> expected) {
        HumanEval30 s = new HumanEval30();
        List<Integer> result = s.getPositive(new ArrayList<>(input));
        assertEquals(expected, result);
    }
    private static java.util.stream.Stream<Arguments> provideLists() {
        return java.util.stream.Stream.of(
            Arguments.of(Arrays.asList(-1, -2, 4, 5, 6), Arrays.asList(4, 5, 6)),
            Arguments.of(Arrays.asList(5, 3, -5, 2, 3, 3, 9, 0, 123, 1, -10), Arrays.asList(5, 3, 2, 3, 3, 9, 123, 1)),
            Arguments.of(Collections.emptyList(), Collections.emptyList()) // mutated edge case: empty list
        );
    }

}
