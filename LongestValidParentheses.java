import java.util.Stack;

/**
 * Leetcode problem #32, Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

  public static void main(String[] args) {
    String s = ")()())";
    int len = longestValidParentheses(s);
    System.out.println(len);
  }

  public static int longestValidParentheses(String s) {
    int l = 0, len = 0;
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')' && !st.isEmpty() && s.charAt(st.peek()) == '(') {
        st.pop();
        l = st.isEmpty() ? -1 : st.peek();
        len = Math.max(len, i - l);
        continue;
      }
      st.push(i);
    }

    return len;
  }
}
