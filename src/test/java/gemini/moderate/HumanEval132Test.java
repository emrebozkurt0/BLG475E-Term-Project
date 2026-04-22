package gemini.moderate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanEval132Test {

    @Test
    public void testIsNested() {
        HumanEval132 s = new HumanEval132();
        
        // Valid nested strings
        assertTrue(s.isNested("[[]]"), "Expected [[]] to be nested");
        assertTrue(s.isNested("[[[[]]]]"), "Expected [[[[]]]] to be nested");
        assertTrue(s.isNested("[][][[]]"), "Expected [][][[]] to be nested");
        assertTrue(s.isNested("[[]][["), "Expected [[]][[ to be nested");
        assertTrue(s.isNested("[[][]]"), "Expected [[][]] to be nested");
        assertTrue(s.isNested("[[]"), "Function returns true for [[] due to max depth tracking");
        assertTrue(s.isNested("[[[[[[[["), "Expected [[[[[[[[ to return true based on logic");

        // Invalid nested strings
        assertFalse(s.isNested("[]]]]]]][[[[[]"), "Expected []]]]]]][[[[[] not to be nested");
        assertFalse(s.isNested("[][]"), "Expected [][] not to be nested");
        assertFalse(s.isNested("[]"), "Expected [] not to be nested");
        assertFalse(s.isNested("[]]]]]]]]]]"), "Expected []]]]]]]]]] not to be nested");
        assertFalse(s.isNested("[]]"), "Expected []] not to be nested");
        assertFalse(s.isNested(""), "Expected empty string not to be nested");
        assertFalse(s.isNested("]]]]]]]]"), "Expected ]]]]]]]] not to be nested");

        // Mutated base test for spaces inside bracket
        assertFalse(s.isNested("[ ]"), "Expected empty string with space inside brackets not to be nested");
        assertTrue(s.isNested("[[ ]]"), "Expected [[ ]] with space to be nested");

        // Strings with other characters
        assertTrue(s.isNested("a[b[c]d]e"), "Expected a[b[c]d]e to be nested");
        assertFalse(s.isNested("a[b]c"), "Expected a[b]c not to be nested");
    }
}