package gemini.easy;
import java.util.stream.Stream;
import java.util.Random;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval53Test {
    @ParameterizedTest
    @MethodSource("provideNumbers")
    public void testAdd(int a, int b, int expected) {
        HumanEval53 s = new HumanEval53();
        int result = s.add(a, b);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideNumbers() {
        Stream.Builder<Arguments> builder = Stream.builder();
        
        // Fixed parameters
        builder.add(Arguments.of(0, 1, 1));
        builder.add(Arguments.of(1, 0, 1));
        builder.add(Arguments.of(2, 3, 5));
        builder.add(Arguments.of(5, 7, 12));
        builder.add(Arguments.of(7, 5, 12));
        // mutated base tests for negative numbers
        builder.add(Arguments.of(-2, -3, -5));
        builder.add(Arguments.of(-3, 2, -1));
        
        // Random parameters
        Random rand = new Random();
        int limit = 100;
        int bound = 1000;
        for (int i = 0; i < limit; i++) {
            int x = rand.nextInt(bound);
            int y = rand.nextInt(bound);
            builder.add(Arguments.of(x, y, x + y));
        }
        return builder.build();
    }

}
