import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode problem #22, Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 * Using Backtracking approach
 */
public class GenerateParenthesesM1 {
    public static void main(String[] args) {
        List<String> res = generateParenthese(3);
        System.out.println(res);
    }

    static List<String> generateParenthese(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backTracker(res, sb, 0, 0, n);

        return res;
    }

    static void backTracker(List<String> res, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            backTracker(res, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(")");
            backTracker(res, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
