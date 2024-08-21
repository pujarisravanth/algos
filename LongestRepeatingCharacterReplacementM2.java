/**
 * Leetcode problem #424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * Doing this in O(n)
 */
public class LongestRepeatingCharacterReplacementM2 {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int res = 0, l = 0;
        int[] charMap = new int[26];
        int max = 0;

        for (int r = 0; r < s.length(); r++) {
            charMap[s.charAt(r) - 'A']++;

            /**
             * Sometimes this max won't be the exact max. but we already got the resukt with
             * the max, we don't need to decrement that value.
             * Our main objective is window - max.frequent <= k
             */
            max = Math.max(max, charMap[s.charAt(r) - 'A']);
            while ((r - l + 1) - max > k) {
                charMap[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
