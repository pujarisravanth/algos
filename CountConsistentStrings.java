/**
 * Leetcode problem #1684, Count the Number of Consistent Strings
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/
 */
public class CountConsistentStrings {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = new String[] { "ad", "bd", "aaab", "baa", "badab" };
        System.out.println(countConsistentStrings(allowed, words));
    }

    static int countConsistentStrings(String allowed, String[] words) {
        boolean[] map1 = new boolean[26];
        for (char c : allowed.toCharArray()) {
            map1[c - 'a'] = true;
        }

        int res = 0;
        boolean add = false;
        for (String word : words) {
            add = true;
            for (char c : word.toCharArray()) {
                if (!map1[c - 'a']) {
                    add = false;
                    break;
                }
            }

            res += add ? 1 : 0;
        }

        return res;
    }
}
