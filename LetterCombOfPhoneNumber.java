import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Leetcode #17, Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombOfPhoneNumber {
    private ArrayList<String> res = new ArrayList<>();
    private Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String input;

    public static void main(String[] args) {
        String digits = "23";
        LetterCombOfPhoneNumber obj = new LetterCombOfPhoneNumber();
        System.out.println(obj.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }

        input = digits;
        backtrack(new StringBuilder(), 0);

        return res;
    }

    public void backtrack(StringBuilder sb, int index) {
        if (index == input.length()) {
            res.add(sb.toString());
            return;
        }

        String s = map.get(input.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtrack(sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
