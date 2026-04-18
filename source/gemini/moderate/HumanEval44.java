import java.util.*;
import java.lang.*;

public class HumanEval44 {
    public String changeBase(int x, int base) {
        StringBuilder ret = new StringBuilder();
        while (x > 0) {
            ret.append(String.valueOf(x % base));
            x /= base;
        }
        return ret.reverse().toString();
    }
}
