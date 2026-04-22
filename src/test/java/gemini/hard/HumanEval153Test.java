package gemini.hard;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval153Test {
    @Test
    public void testStrongestExtension1() {
        HumanEval153 s = new HumanEval153();
        assertEquals("Watashi.eIGHt8OKe", s.StrongestExtension("Watashi", Arrays.asList("tEN", "niNE", "eIGHt8OKe")));
    }

    @Test
    public void testStrongestExtension2() {
        HumanEval153 s = new HumanEval153();
        assertEquals("Boku123.YEs.WeCaNe", s.StrongestExtension("Boku123", Arrays.asList("nani", "NazeDa", "YEs.WeCaNe", "32145tggg")));
    }

    @Test
    public void testStrongestExtension3() {
        HumanEval153 s = new HumanEval153();
        assertEquals("__YESIMHERE.NuLl__", s.StrongestExtension("__YESIMHERE", Arrays.asList("t", "eMptY", "nothing", "zeR00", "NuLl__", "123NoooneB321")));
    }

    @Test
    public void testStrongestExtensionTie() {
        HumanEval153 s = new HumanEval153();
        assertEquals("K.TAR", s.StrongestExtension("K", Arrays.asList("Ta", "TAR", "t234An", "cosSo")));
    }

    @Test
    public void testStrongestExtensionMisc() {
        HumanEval153 s = new HumanEval153();
        assertEquals("__HAHA.123", s.StrongestExtension("__HAHA", Arrays.asList("Tab", "123", "781345", "-_-")));
        assertEquals("YameRore.okIWILL123", s.StrongestExtension("YameRore", Arrays.asList("HhAas", "okIWILL123", "WorkOut", "Fails", "-_-")));
        assertEquals("finNNalLLly.WoW", s.StrongestExtension("finNNalLLly", Arrays.asList("Die", "NowW", "Wow", "WoW")));
        assertEquals("_.Bb", s.StrongestExtension("_", Arrays.asList("Bb", "91245")));
        assertEquals("Sp.671235", s.StrongestExtension("Sp", Arrays.asList("671235", "Bb")));
    }
}
