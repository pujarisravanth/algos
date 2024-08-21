/**
 * Leetcode problem #424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * Doing this in O(26n) time complexity ==> O(n) time complexity
 */
public class LongestRepeatingCharacterReplacementM1 {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int res = 0, l = 0;
        int[] charMap = new int[26];

        for (int r = 0; r < s.length(); r++) {
            charMap[s.charAt(r) - 'A']++;

            while ((r - l + 1) - getMax(charMap) > k) {
                charMap[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static int getMax(int[] arr) {
        int max = 0;

        for (int i : arr) {
            max = Math.max(max, i);
        }

        return max;
    }
}