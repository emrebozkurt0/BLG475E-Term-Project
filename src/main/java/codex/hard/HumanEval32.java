package codex.hard;

import java.util.*;
import java.lang.*;

public class HumanEval32 {

    public double poly(List<Double> xs, double x) {
        double res = 0.0;
        for (int i = 0; i < xs.size(); i++) {
            res += xs.get(i) * Math.pow(x, i);
        }
        return res;
    }
    
    public double findZero(List<Double> xs) {
        double left = -1.0;
        double right = 1.0;
        double fLeft = poly(xs, left);
        double fRight = poly(xs, right);

        if (Math.abs(fLeft) < 1e-14) {
            return left;
        }
        if (Math.abs(fRight) < 1e-14) {
            return right;
        }

        int expandSteps = 0;
        while (fLeft * fRight > 0.0 && expandSteps < 100) {
            left *= 2.0;
            right *= 2.0;
            fLeft = poly(xs, left);
            fRight = poly(xs, right);
            expandSteps++;
        }

        for (int i = 0; i < 200; i++) {
            double mid = (left + right) / 2.0;
            double fMid = poly(xs, mid);

            if (Math.abs(fMid) < 1e-12) {
                return mid;
            }

            if (fLeft * fMid <= 0.0) {
                right = mid;
                fRight = fMid;
            } else {
                left = mid;
                fLeft = fMid;
            }
        }

        return (left + right) / 2.0;
    }
}
