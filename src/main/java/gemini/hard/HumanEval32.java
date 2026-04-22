package gemini.hard;

import java.util.*;
import java.lang.*;

public class HumanEval32 {
    /**
    xs are coefficients of a polynomial.
    findZero(Arrays.asList(1, 2)) returns -0.5 (1 + 2 * -0.5 = 0)
    findZero(Arrays.asList(-6, 11, -6, 1)) returns 1.0 ((-6) + 11*1 + (-6)*1**2 + 1*1**3 = 0)
    Only list with even number of coefficients are given.
    The largest coefficient is always not zero.
     */
    public double poly(List<Double> xs, double x) {
        double res = 0.0;
        for (int i = 0; i < xs.size(); i++) {
            res += xs.get(i) * Math.pow(x, i);
        }
        return res;
    }

    public double findZero(List<Double> xs) {
        double begin = -100.0;
        double end = 100.0;
        while (Math.abs(poly(xs, begin)) > 1e-10) {
            double mid = (begin + end) / 2;
            if (poly(xs, begin) * poly(xs, mid) <= 0) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        return begin;
    }
}
