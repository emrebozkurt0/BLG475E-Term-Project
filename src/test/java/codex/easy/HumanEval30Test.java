package codex.easy;

import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval30Test {
    @ParameterizedTest
    @MethodSource("getPositiveCases")
    public void testGetPositive(List<Integer> input, List<Integer> expected) {
        HumanEval30 s = new HumanEval30();
    assertEquals(expected, s.getPositive(new ArrayList<>(input)));
    }

    private static Stream<Arguments> getPositiveCases() {
    return Stream.of(
        Arguments.of(
            List.of(-1, -2, 4, 5, 6),
            List.of(4, 5, 6)
        ),
        Arguments.of(
            List.of(5, 3, -5, 2, 3, 3, 9, 0, 123, 1, -10),
            List.of(5, 3, 2, 3, 3, 9, 123, 1)
        )
    );
    }
}