/* @Authors
* Student Names: Mustafa Berkay Arslan, Emre Bozkurt, Harun Yahya Demirpençe
* Student IDs: 150210023, 150210030, 150210022
*/

package gemini.moderate;

import java.util.*;
import java.lang.*;

public class HumanEval132 {
    public boolean isNested(String string) {
        int count = 0, max_depth = 0;
        for (char c : string.toCharArray()) {
            if (c == '[') {
                count++;
                max_depth = Math.max(max_depth, count);
            } else if (c == ']') {
                count--;
            }
        }
        return max_depth >= 2;
    }
}
