import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode problem #22, Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 * Using Divide and Conquer approach
 * Better to go with the Backtracking approach
 */
public class GenerateParenthesesM2 {
    public static void main(String[] args) {
        List<String> res = generateParentheses(3);
        System.out.println(res);
    }

    static List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
            return res;
        }

        for (int i = 0; i < n; i++) {
            for (String leftString : generateParentheses(i)) {
                for (String rightString : generateParentheses(n - 1 - i)) {
                    res.add("(" + leftString + ")" + rightString);
                }
            }
        }

        return res;
    }
}
