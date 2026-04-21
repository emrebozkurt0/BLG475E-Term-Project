package gemini.easy;
import java.util.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class HumanEval35Test {
    @ParameterizedTest
    @MethodSource("provideLists")
    public void testMaxElement(List<Integer> input, int expected) {
        HumanEval35 s = new HumanEval35();
        int result = s.maxElement(new ArrayList<>(input));
        assertEquals(expected, result);
    }
    private static java.util.stream.Stream<Arguments> provideLists() {
        return java.util.stream.Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3), 3),
            Arguments.of(Arrays.asList(5, 3, -5, 2, -3, 3, 9, 0, 124, 1, -10), 124)
        );
    }
}