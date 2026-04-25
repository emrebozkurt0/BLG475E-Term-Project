package gemini.hard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval153Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> provideExtensionData() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of("Watashi", Arrays.asList("tEN", "niNE", "eIGHt8OKe"), "Watashi.eIGHt8OKe", null),
            org.junit.jupiter.params.provider.Arguments.of("Boku123", Arrays.asList("nani", "NazeDa", "YEs.WeCaNe", "32145tggg"), "Boku123.YEs.WeCaNe", null),
            org.junit.jupiter.params.provider.Arguments.of("__YESIMHERE", Arrays.asList("t", "eMptY", "nothing", "zeR00", "NuLl__", "123NoooneB321"), "__YESIMHERE.NuLl__", null),
            org.junit.jupiter.params.provider.Arguments.of("K", Arrays.asList("Ta", "TAR", "t234An", "cosSo"), "K.TAR", null),
            org.junit.jupiter.params.provider.Arguments.of("__HAHA", Arrays.asList("Tab", "123", "781345", "-_-"), "__HAHA.123", null),
            org.junit.jupiter.params.provider.Arguments.of("YameRore", Arrays.asList("HhAas", "okIWILL123", "WorkOut", "Fails", "-_-"), "YameRore.okIWILL123", null),
            org.junit.jupiter.params.provider.Arguments.of("finNNalLLly", Arrays.asList("Die", "NowW", "Wow", "WoW"), "finNNalLLly.WoW", null),
            org.junit.jupiter.params.provider.Arguments.of("_", Arrays.asList("Bb", "91245"), "_.Bb", null),
            org.junit.jupiter.params.provider.Arguments.of("Sp", Arrays.asList("671235", "Bb"), "Sp.671235", null),
            org.junit.jupiter.params.provider.Arguments.of("C", Arrays.asList("Ab", "aB", "Zz"), "C.Ab", null),
            org.junit.jupiter.params.provider.Arguments.of("Only", java.util.List.of("Ext"), "Only.Ext", null),
            org.junit.jupiter.params.provider.Arguments.of(null, java.util.List.of("Ext"), "null.Ext", null),
            org.junit.jupiter.params.provider.Arguments.of("C", java.util.List.of(), "C.null", null),
            org.junit.jupiter.params.provider.Arguments.of("C", null, null, NullPointerException.class),
            org.junit.jupiter.params.provider.Arguments.of("C", Arrays.asList("AB", null), null, NullPointerException.class)
        );
    }

    private void executeExtensionAssertion(HumanEval153 s, String className, java.util.List<String> extensions, String expected, Class<? extends Throwable> expectedException) {
        if (expectedException != null) {
            assertThrows(expectedException, () -> s.StrongestExtension(className, extensions));
        } else {
            assertEquals(expected, s.StrongestExtension(className, extensions), "StrongestExtension output should match expected");
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideExtensionData")
    public void testStrongestExtension(String className, java.util.List<String> extensions, String expected, Class<? extends Throwable> expectedException) {
        HumanEval153 s = new HumanEval153();
        org.junit.jupiter.api.Assertions.assertNotNull(s);
        executeExtensionAssertion(s, className, extensions, expected, expectedException);
    }
}
