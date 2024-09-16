import java.util.Arrays;

/**
 * Leetcode problem #1657, Determine if Two Strings Are Close
 * https://leetcode.com/problems/determine-if-two-strings-are-close/
 */
public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";
        System.out.println(closeStrings(word1, word2));
    }

    static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int[] map1 = new int[26];
        for (char c : word1.toCharArray()) {
            map1[c - 'a']++;
        }

        int[] map2 = new int[26];
        for (char c : word2.toCharArray()) {
            map2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((map1[i] == 0 && map2[i] != 0) || (map1[i] != 0 && map2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(map1);
        Arrays.sort(map2);

        return Arrays.equals(map1, map2);
    }
}
