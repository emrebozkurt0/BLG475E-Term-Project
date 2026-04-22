package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval153Test {
    @Test
    public void testStrongestExtension() {
        HumanEval153 s = new HumanEval153();

        String[] classNames = {
            "Watashi", "Boku123", "__YESIMHERE", "K", "__HAHA", 
            "YameRore", "finNNalLLly", "_", "Sp"
        };
        
        java.util.List<java.util.List<String>> extensionsList = Arrays.asList(
            Arrays.asList("tEN", "niNE", "eIGHt8OKe"),
            Arrays.asList("nani", "NazeDa", "YEs.WeCaNe", "32145tggg"),
            Arrays.asList("t", "eMptY", "nothing", "zeR00", "NuLl__", "123NoooneB321"),
            Arrays.asList("Ta", "TAR", "t234An", "cosSo"),
            Arrays.asList("Tab", "123", "781345", "-_-"),
            Arrays.asList("HhAas", "okIWILL123", "WorkOut", "Fails", "-_-"),
            Arrays.asList("Die", "NowW", "Wow", "WoW"),
            Arrays.asList("Bb", "91245"),
            Arrays.asList("671235", "Bb")
        );

        String[] expectedOutputs = {
            "Watashi.eIGHt8OKe",
            "Boku123.YEs.WeCaNe",
            "__YESIMHERE.NuLl__",
            "K.TAR",
            "__HAHA.123",
            "YameRore.okIWILL123",
            "finNNalLLly.WoW",
            "_.Bb",
            "Sp.671235"
        };

        for (int i = 0; i < classNames.length; i++) {
            assertEquals(expectedOutputs[i], 
                s.StrongestExtension(classNames[i], extensionsList.get(i)),
                "StrongestExtension for " + classNames[i] + " should return " + expectedOutputs[i]);
        }
    }
}
