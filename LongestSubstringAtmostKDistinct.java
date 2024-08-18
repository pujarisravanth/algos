/**
 * Leetcode problem #340, Longest Substring with Atmost k Distinct Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 */
public class LongestSubstringAtmostKDistinct {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0, len = 0, distinct = 0;
        int[] charArr = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int key = s.charAt(i);
            if (charArr[key] == 0) {
                distinct++;
            }
            charArr[key]++;

            while (distinct == k + 1) {
                int startKey = s.charAt(start);
                charArr[startKey]--;
                start++;
                if (charArr[startKey] == 0) {
                    distinct--;
                }
            }

            len = Math.max(i - start + 1, len);
        }

        return len;
    }
}
