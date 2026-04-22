package gemini.hard;

import java.util.*;
import java.lang.*;

public class HumanEval153 {
    /**
    You will be given the name of a class (a string) and a list of extensions.
    The extensions are to be used to load additional classes to the class. The
    strength of the extension is as follows: Let CAP be the number of the uppercase
    letters in the extension's name, and let SM be the number of lowercase letters
    in the extension's name, the strength is given by the fraction CAP - SM.
    You should find the strongest extension and return a string in this
    format: ClassName.StrongestExtensionName.
    If there are two or more extensions with the same strength, you should
    choose the one that comes first in the list.
    For example, if you are given "Slices" as the class and a list of the
    extensions: ["SErviNGSliCes", "Cheese", "StuFfed"] then you should
    return "Slices.SErviNGSliCes" since "SErviNGSliCes" is the strongest extension
    (its strength is -1).
    Example:
    for StrongestExtension("my_class", ["AA", "Be", "CC"]) == "my_class.AA"
     */
    public String StrongestExtension(String class_name, List<String> extensions) {
        String strongestExtension = null;
        int maxStrength = Integer.MIN_VALUE;

        for (String ext : extensions) {
            int strength = 0;
            for (int i = 0; i < ext.length(); i++) {
                char c = ext.charAt(i);
                if (Character.isUpperCase(c)) {
                    strength++;
                } else if (Character.isLowerCase(c)) {
                    strength--;
                }
            }
            
            // If the strength is strictly greater than maxStrength, update.
            // This ensures that in case of a tie, the first one is kept.
            if (strength > maxStrength) {
                maxStrength = strength;
                strongestExtension = ext;
            }
        }

        return class_name + "." + strongestExtension;
    }
}
