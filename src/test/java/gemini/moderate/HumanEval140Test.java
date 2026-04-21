package gemini.moderate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval140Test {

    @Test
    public void testFixSpaces() {
        HumanEval140 s = new HumanEval140();
        
        // No spaces
        assertEquals("Example", s.fixSpaces("Example"), "Expected no spaces to remain unchanged");

        // Single and double spaces
        assertEquals("Mudasir_Hanif_", s.fixSpaces("Mudasir Hanif "), "Expected single space to be replaced by an underscore");
        assertEquals("Yellow_Yellow__Dirty__Fellow", s.fixSpaces("Yellow Yellow  Dirty  Fellow"), "Expected double spaces to be replaced by double underscores");

        // Multiple spaces inside
        assertEquals("Exa-mple", s.fixSpaces("Exa   mple"), "Expected three consecutive spaces to be replaced by a hyphen");
        assertEquals("-Exa_1_2_2_mple", s.fixSpaces("   Exa 1 2 2 mple"), "Expected multiple leading spaces to be replaced by a hyphen and single spaces to be underscores");

        // Multiple spaces at end
        assertEquals("abc-", s.fixSpaces("abc   "), "Expected multiple trailing spaces to be replaced by a hyphen");
        assertEquals("-", s.fixSpaces("   "), "Expected a string containing only multiple spaces to be combined into a hyphen");
    }
}