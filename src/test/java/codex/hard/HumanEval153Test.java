package codex.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval153Test {

    @Test
    public void strongestExtension_matchesReferenceExamples() {
        HumanEval153 solution = new HumanEval153();

        assertEquals("Watashi.eIGHt8OKe", solution.StrongestExtension("Watashi", Arrays.asList("tEN", "niNE", "eIGHt8OKe")));
        assertEquals("Boku123.YEs.WeCaNe", solution.StrongestExtension("Boku123", Arrays.asList("nani", "NazeDa", "YEs.WeCaNe", "32145tggg")));
        assertEquals("__YESIMHERE.NuLl__", solution.StrongestExtension("__YESIMHERE", Arrays.asList("t", "eMptY", "nothing", "zeR00", "NuLl__", "123NoooneB321")));
        assertEquals("K.TAR", solution.StrongestExtension("K", Arrays.asList("Ta", "TAR", "t234An", "cosSo")));
        assertEquals("__HAHA.123", solution.StrongestExtension("__HAHA", Arrays.asList("Tab", "123", "781345", "-_-")));
        assertEquals("YameRore.okIWILL123", solution.StrongestExtension("YameRore", Arrays.asList("HhAas", "okIWILL123", "WorkOut", "Fails", "-_-")));
        assertEquals("finNNalLLly.WoW", solution.StrongestExtension("finNNalLLly", Arrays.asList("Die", "NowW", "Wow", "WoW")));
        assertEquals("_.Bb", solution.StrongestExtension("_", Arrays.asList("Bb", "91245")));
        assertEquals("Sp.671235", solution.StrongestExtension("Sp", Arrays.asList("671235", "Bb")));
    }

    @Test
    public void strongestExtension_keepsFirstWhenStrengthsTie() {
        HumanEval153 solution = new HumanEval153();

        assertEquals("C.Ab", solution.StrongestExtension("C", Arrays.asList("Ab", "aB", "Zz")));
    }

    @Test
    public void strongestExtension_handlesSingleExtensionList() {
        HumanEval153 solution = new HumanEval153();

        assertEquals("Only.Ext", solution.StrongestExtension("Only", List.of("Ext")));
    }
}
