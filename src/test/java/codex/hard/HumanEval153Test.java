package codex.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanEval153Test {

    @ParameterizedTest(name = "StrongestExtension case {index}")
    @MethodSource("strongestExtensionCases")
    public void strongestExtension_returnsExpectedValue(String className, List<String> extensions, String expected) {
        HumanEval153 solution = new HumanEval153();
        assertEquals(expected, solution.StrongestExtension(className, extensions));
    }

    private static Stream<Arguments> strongestExtensionCases() {
        return Stream.of(
                Arguments.of("Watashi", Arrays.asList("tEN", "niNE", "eIGHt8OKe"), "Watashi.eIGHt8OKe"),
                Arguments.of("Boku123", Arrays.asList("nani", "NazeDa", "YEs.WeCaNe", "32145tggg"), "Boku123.YEs.WeCaNe"),
                Arguments.of("__YESIMHERE", Arrays.asList("t", "eMptY", "nothing", "zeR00", "NuLl__", "123NoooneB321"), "__YESIMHERE.NuLl__"),
                Arguments.of("K", Arrays.asList("Ta", "TAR", "t234An", "cosSo"), "K.TAR"),
                Arguments.of("__HAHA", Arrays.asList("Tab", "123", "781345", "-_-"), "__HAHA.123"),
                Arguments.of("YameRore", Arrays.asList("HhAas", "okIWILL123", "WorkOut", "Fails", "-_-"), "YameRore.okIWILL123"),
                Arguments.of("finNNalLLly", Arrays.asList("Die", "NowW", "Wow", "WoW"), "finNNalLLly.WoW"),
                Arguments.of("_", Arrays.asList("Bb", "91245"), "_.Bb"),
                Arguments.of("Sp", Arrays.asList("671235", "Bb"), "Sp.671235"),
                Arguments.of("C", Arrays.asList("Ab", "aB", "Zz"), "C.Ab"),
                Arguments.of("Only", List.of("Ext"), "Only.Ext"),
                // Mutation tests for uncovered ECs: EC7 (null class name)
                Arguments.of(null, List.of("Ext"), "null.Ext")
        );
    }

    @org.junit.jupiter.api.Test
    public void strongestExtension_mutation_emptyExtensions_throwsException() {
        // Mutation tests for uncovered ECs: EC6 (empty extensions)
        HumanEval153 solution = new HumanEval153();
        assertThrows(IndexOutOfBoundsException.class, () -> solution.StrongestExtension("C", List.of()));
    }

    @org.junit.jupiter.api.Test
    public void strongestExtension_mutation_nullExtensions_throwsException() {
        // Mutation tests for uncovered ECs: EC6 (null extensions)
        HumanEval153 solution = new HumanEval153();
        assertThrows(NullPointerException.class, () -> solution.StrongestExtension("C", null));
    }

    @org.junit.jupiter.api.Test
    public void strongestExtension_mutation_nullExtensionEntry_throwsException() {
        // Mutation tests for uncovered ECs: EC7 (null extension entry)
        HumanEval153 solution = new HumanEval153();
        assertThrows(NullPointerException.class, () -> solution.StrongestExtension("C", Arrays.asList("AB", null)));
    }
}
