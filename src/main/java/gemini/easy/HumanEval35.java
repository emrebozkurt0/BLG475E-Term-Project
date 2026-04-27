/* @Authors
* Student Names: Mustafa Berkay Arslan, Emre Bozkurt, Harun Yahya Demirpençe
* Student IDs: 150210023, 150210030, 150210022
*/

package gemini.easy;

import java.util.*;
import java.lang.*;

public class HumanEval35 {
    public int maxElement(List<Integer> l) {
        int max = l.get(0);
        for (int n : l) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}
