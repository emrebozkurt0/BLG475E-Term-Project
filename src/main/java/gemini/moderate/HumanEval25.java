/* @Authors
* Student Names: Mustafa Berkay Arslan, Emre Bozkurt, Harun Yahya Demirpençe
* Student IDs: 150210023, 150210030, 150210022
*/

package gemini.moderate;

import java.util.*;
import java.lang.*;

public class HumanEval25 {
    public List<Integer> factorize(int n) {
        List<Integer> result = new ArrayList<>();
        int i = 2;
        while (i <= (int) (Math.sqrt(n) + 1.0)) {
            if (n % i == 0) {
                result.add(i);
                n /= i;
            } else {
                i++;
            }
        }

        if (n > 1) {
            result.add(n);
        }
        return result;
    }
}
