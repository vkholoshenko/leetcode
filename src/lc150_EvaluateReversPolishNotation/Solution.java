package lc150_EvaluateReversPolishNotation;

import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

*/
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int p1 = stack.pop(), p2 = stack.pop();
                stack.push(p1 + p2);
            } else if (token.equals("-")) {
                int p1 = stack.pop(), p2 = stack.pop();
                stack.push(p2 - p1);
            } else if (token.equals("*")) {
                int p1 = stack.pop(), p2 = stack.pop();
                stack.push(p2 * p1);
            } else if (token.equals("/")) {
                int p1 = stack.pop(), p2 = stack.pop();
                stack.push(p2 / p1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}