package gemini.hard;

import java.util.*;
import java.lang.*;

public class HumanEval160 {
    /**
    Given two lists operator, and operand. The first list has basic algebra operations, and
    the second list is a list of integers. Use the two given lists to build the algebric
    expression and return the evaluation of this expression.

    The basic algebra operations:
    Addition ( + )
    Subtraction ( - )
    Multiplication ( * )
    Floor division ( / )
    Exponentiation ( ** )

    Example:
    operator["+", "*", "-"]
    array = [2, 3, 4, 5]
    result = 2 + 3 * 4 - 5
    => result = 9

    Note:
        The length of operator list is equal to the length of operand list minus one.
        Operand is a list of of non-negative integers.
        Operator list has at least one operator, and operand list has at least two operands.
     */
    public int doAlgebra(List<String> operator, List<Integer> operand) {
        // Create mutable copies of the lists
        List<String> ops = new ArrayList<>(operator);
        List<Integer> vals = new ArrayList<>(operand);

        // Precedence 1: Exponentiation (**)
        // Generally right-associative, so we iterate from right to left
        for (int i = ops.size() - 1; i >= 0; i--) {
            if (ops.get(i).equals("**")) {
                int a = vals.get(i);
                int b = vals.get(i + 1);
                vals.set(i, (int) Math.pow(a, b));
                vals.remove(i + 1);
                ops.remove(i);
            }
        }

        // Precedence 2: Multiplication (*), Floor division (/, //)
        // Left-associative, so we iterate from left to right
        for (int i = 0; i < ops.size(); i++) {
            String op = ops.get(i);
            if (op.equals("*") || op.equals("/") || op.equals("//")) {
                int a = vals.get(i);
                int b = vals.get(i + 1);
                if (op.equals("*")) {
                    vals.set(i, a * b);
                } else {
                    // Integer division in Java naturally floors non-negative values
                    vals.set(i, a / b);
                }
                vals.remove(i + 1);
                ops.remove(i);
                // Adjust index after concurrent structural modification
                i--;
            }
        }

        // Precedence 3: Addition (+), Subtraction (-)
        // Left-associative, so we iterate from left to right
        for (int i = 0; i < ops.size(); i++) {
            String op = ops.get(i);
            if (op.equals("+") || op.equals("-")) {
                int a = vals.get(i);
                int b = vals.get(i + 1);
                if (op.equals("+")) {
                    vals.set(i, a + b);
                } else {
                    vals.set(i, a - b);
                }
                vals.remove(i + 1);
                ops.remove(i);
                // Adjust index after concurrent structural modification
                i--;
            }
        }

        return vals.get(0);
    }
}

