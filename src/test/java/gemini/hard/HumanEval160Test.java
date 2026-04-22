package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval160Test {
    @Test
    public void testDoAlgebraAll() {
        HumanEval160 s = new HumanEval160();

        int expected1 = 37;
        ArrayList<String> ops1 = new ArrayList<>(Arrays.asList("**", "*", "+"));
        ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        assertEquals(expected1, s.doAlgebra(ops1, nums1), "doAlgebra test 1 failed");

        int expected2 = 9;
        ArrayList<String> ops2 = new ArrayList<>(Arrays.asList("+", "*", "-"));
        ArrayList<Integer> nums2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        assertEquals(expected2, s.doAlgebra(ops2, nums2), "doAlgebra test 2 failed");

        int expected3 = 8;
        ArrayList<String> ops3 = new ArrayList<>(Arrays.asList("/", "*"));
        ArrayList<Integer> nums3 = new ArrayList<>(Arrays.asList(7, 3, 4));
        assertEquals(expected3, s.doAlgebra(ops3, nums3), "doAlgebra test 3 failed");

        int expected4 = 1953132;
        ArrayList<String> ops4 = new ArrayList<>(Arrays.asList("+", "**", "**"));
        ArrayList<Integer> nums4 = new ArrayList<>(Arrays.asList(7, 5, 3, 2));
        assertEquals(expected4, s.doAlgebra(ops4, nums4), "doAlgebra test 4 failed");

        int expectedFloorDiv = 2;
        ArrayList<String> opsFloorDiv = new ArrayList<>(Arrays.asList("//"));
        ArrayList<Integer> numsFloorDiv = new ArrayList<>(Arrays.asList(7, 3));
        assertEquals(expectedFloorDiv, s.doAlgebra(opsFloorDiv, numsFloorDiv), "doAlgebra floor div failed");

        int expectedInvalid = 2;
        ArrayList<String> opsInvalid = new ArrayList<>(Arrays.asList("?"));
        ArrayList<Integer> numsInvalid = new ArrayList<>(Arrays.asList(2, 3));
        assertEquals(expectedInvalid, s.doAlgebra(opsInvalid, numsInvalid), "doAlgebra invalid op failed");
    }
}
