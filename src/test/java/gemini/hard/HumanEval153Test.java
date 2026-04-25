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
            org.junit.jupiter.params.provider.Arguments.of("Watashi", Arrays.asList("tEN", "niNE", "eIGHt8OKe"), "Watashi.eIGHt8OKe"),
            org.junit.jupiter.params.provider.Arguments.of("Boku123", Arrays.asList("nani", "NazeDa", "YEs.WeCaNe", "32145tggg"), "Boku123.YEs.WeCaNe"),
            org.junit.jupiter.params.provider.Arguments.of("__YESIMHERE", Arrays.asList("t", "eMptY", "nothing", "zeR00", "NuLl__", "123NoooneB321"), "__YESIMHERE.NuLl__"),
            org.junit.jupiter.params.provider.Arguments.of("K", Arrays.asList("Ta", "TAR", "t234An", "cosSo"), "K.TAR"),
            org.junit.jupiter.params.provider.Arguments.of("__HAHA", Arrays.asList("Tab", "123", "781345", "-_-"), "__HAHA.123"),
            org.junit.jupiter.params.provider.Arguments.of("YameRore", Arrays.asList("HhAas", "okIWILL123", "WorkOut", "Fails", "-_-"), "YameRore.okIWILL123"),
            org.junit.jupiter.params.provider.Arguments.of("finNNalLLly", Arrays.asList("Die", "NowW", "Wow", "WoW"), "finNNalLLly.WoW"),
            org.junit.jupiter.params.provider.Arguments.of("_", Arrays.asList("Bb", "91245"), "_.Bb"),
            org.junit.jupiter.params.provider.Arguments.of("Sp", Arrays.asList("671235", "Bb"), "Sp.671235"),
            // Mutation tests for uncovered ECs: EC2 (tie -> first occurrence)
            org.junit.jupiter.params.provider.Arguments.of("C", Arrays.asList("Ab", "aB", "Zz"), "C.Ab"),
            // Mutation tests for uncovered ECs: EC5 (single extension)
            org.junit.jupiter.params.provider.Arguments.of("Only", java.util.List.of("Ext"), "Only.Ext"),
            // Mutation tests for uncovered ECs: EC7 (null class)
            org.junit.jupiter.params.provider.Arguments.of(null, java.util.List.of("Ext"), "null.Ext"),
            // Mutation tests for uncovered ECs: EC6 (empty extension list)
            org.junit.jupiter.params.provider.Arguments.of("C", java.util.List.of(), "C.null")
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideExtensionData")
    public void testStrongestExtension(String className, java.util.List<String> extensions, String expected) {
        HumanEval153 s = new HumanEval153();
        assertEquals(expected, s.StrongestExtension(className, extensions), "StrongestExtension output should match expected");
    }

    static Stream<Arguments> provideInvalidExtensionData() {
        return Stream.of(
            // Mutation tests for uncovered ECs: EC6 (null extensions)
            Arguments.of("C", null, NullPointerException.class),
            // Mutation tests for uncovered ECs: EC7 (null extension entry)
            Arguments.of("C", Arrays.asList("AB", null), NullPointerException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidExtensionData")
    public void testStrongestExtensionInvalidInputs(String className, List<String> extensions, Class<? extends Throwable> expectedException) {
        HumanEval153 s = new HumanEval153();
        assertThrows(expectedException, () -> s.StrongestExtension(className, extensions));
    }
}
