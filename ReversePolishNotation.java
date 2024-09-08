import java.util.Stack;

/**
 * Leetcode problem #150, Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(tokens));
    }

    static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+")) {
                s.push(s.pop() + s.pop());
            } else if (t.equals("-")) {
                int temp = s.pop();
                s.push(s.pop() - temp);
            } else if (t.equals("*")) {
                s.push(s.pop() * s.pop());
            } else if (t.equals("/")) {
                int temp = s.pop();
                s.push(s.pop() / temp);
            } else {
                s.add(Integer.parseInt(t));
            }
        }

        return s.pop();
    }
}
