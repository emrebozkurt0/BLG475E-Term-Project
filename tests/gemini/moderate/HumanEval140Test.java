import java.util.*;
import java.lang.*;

public class HumanEval140Test {
    public static void main(String[] args) {
        HumanEval140 s = new HumanEval140();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.fixSpaces("Example" ), "Example" ),
                Objects.equals(s.fixSpaces("Mudasir Hanif " ), "Mudasir_Hanif_" ),
                Objects.equals(s.fixSpaces("Yellow Yellow  Dirty  Fellow" ), "Yellow_Yellow__Dirty__Fellow" ),
                Objects.equals(s.fixSpaces("Exa   mple" ), "Exa-mple" ),
                Objects.equals(s.fixSpaces("   Exa 1 2 2 mple" ), "-Exa_1_2_2_mple" )
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}
