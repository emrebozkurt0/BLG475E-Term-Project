package codex.hard;

import java.util.*;
import java.lang.*;

public class HumanEval124 {
    public boolean validDate(String date) {
        if (date == null || date.length() == 0) {
            return false;
        }

        String[] parts = date.split("-");
        if (parts.length != 3) {
            return false;
        }

        if (parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 4) {
            return false;
        }

        int month, day, year;
        try {
            month = Integer.parseInt(parts[0]);
            day = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }

        if (day < 1) {
            return false;
        }

        if (month == 2) {
            return day <= 29;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }

        return day <= 31;
    }
}
