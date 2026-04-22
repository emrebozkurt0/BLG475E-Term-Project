package gemini.easy;
import java.util.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class HumanEval28Test {
    @ParameterizedTest
    @MethodSource("provideStrings")
    public void testConcatenate(List<String> input, String expected) {
        HumanEval28 s = new HumanEval28();
        String result = s.concatenate(new ArrayList<>(input));
        assertEquals(expected, result);
    }
    private static java.util.stream.Stream<Arguments> provideStrings() {
        return java.util.stream.Stream.of(
            Arguments.of(List.of(), ""),
            Arguments.of(Arrays.asList("x", "y", "z"), "xyz"),
            Arguments.of(Arrays.asList("x", "y", "z", "w", "k"), "xyzwk"),
            Arguments.of(Collections.singletonList("a"), "a"), // mutated edge case: singleton list
            Arguments.of(Arrays.asList("a", "", "b"), "ab") // mutated edge case: list containing empty strings
        );
    }

}
