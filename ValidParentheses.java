import java.util.Stack;

/**
 * Leetcode problem #20, Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0)
            return true;

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                st.push(c);
            } else {
                if (st.empty())
                    return false;
                char last_char = st.pop();
                if (last_char == '{' && c == '}')
                    continue;
                else if (last_char == '(' && c == ')')
                    continue;
                else if (last_char == '[' && c == ']')
                    continue;
                else
                    return false;
            }
        }

        return st.empty();
    }
}
