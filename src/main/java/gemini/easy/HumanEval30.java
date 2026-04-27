/* @Authors
* Student Names: Mustafa Berkay Arslan, Emre Bozkurt, Harun Yahya Demirpençe
* Student IDs: 150210023, 150210030, 150210022
*/

package gemini.easy;

import java.util.*;
import java.lang.*;

public class HumanEval30 {
    public List<Integer> getPositive(List<Integer> l) {
        List<Integer> result = new ArrayList<>();
        for (int n : l) {
            if (n > 0) {
                result.add(n);
            }
        }
        return result;
    }
}
