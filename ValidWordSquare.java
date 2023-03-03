import java.util.List;

/**
 * Leetcode problem #422, Valid Word Square
 * https://leetcode.com/problems/valid-word-square/
 */
public class ValidWordSquare {
    public static void main(String[] args) {
        List<String> words = List.of("abcd", "bnrt", "crm", "dt");
        System.out.println(validWordSquare(words));
    }

    public static boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= words.size()
                        || i >= words.get(j).length()
                        || words.get(j).charAt(i) != words.get(i).charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
