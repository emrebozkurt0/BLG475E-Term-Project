import java.util.*;
import java.lang.*;

public class HumanEval132Test {
    public static void main(String[] args) {
        HumanEval132 s = new HumanEval132();
        List<Boolean> correct = Arrays.asList(
                s.isNested("[[]]" ),
                !s.isNested("[]]]]]]][[[[[]" ),
                !s.isNested("[][]" ),
                !s.isNested("[]" ),
                s.isNested("[[[[]]]]" ),
                !s.isNested("[]]]]]]]]]]" ),
                s.isNested("[][][[]]" ),
                !s.isNested("[[]" ),
                !s.isNested("[]]" ),
                s.isNested("[[]][[" ),
                s.isNested("[[][]]" ),
                !s.isNested("" ),
                !s.isNested("[[[[[[[[" ),
                !s.isNested("]]]]]]]]" )
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
