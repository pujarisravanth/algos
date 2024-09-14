/**
 * Leetcode problem #1768, Merge Strings Alternately
 * https://leetcode.com/problems/merge-strings-alternately/
 */
public class MergeStringsAlternately {

    public static void main(String[] args) {
        String word1 = "ab", word2 = "pqrs";
        System.out.println(mergeAlternately(word1, word2));
    }

    static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int len = Math.min(word1.length(), word2.length());
        int i = 0;
        for (; i < len; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if (i < word1.length()) {
            sb.append(word1.substring(i));
        }

        if (i < word2.length()) {
            sb.append(word2.substring(i));
        }

        return sb.toString();
    }
}