/**
 * Leetcode problem #151, Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "  a good   example  ";
        System.out.println(reverseWords(s));
    }

    static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
