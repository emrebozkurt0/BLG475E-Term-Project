import java.util.*;
import java.lang.*;

public class HumanEval51 {
    public String removeVowels(String text) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if ("aeiou".indexOf(Character.toLowerCase(ch)) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
