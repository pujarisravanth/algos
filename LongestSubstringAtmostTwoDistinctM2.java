/**
 * Leetcode problem #159, Longest Subsstring with Atmost Two Distinctive
 * Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * Moving start index on by one, till ot the next start.
 */
public class LongestSubstringAtmostTwoDistinctM2 {
    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0, len = 0, distinct = 0;
        int[] charArr = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int key = s.charAt(i);
            if (charArr[key] == 0) {
                distinct++;
            }
            charArr[key]++;

            while (distinct == 3) {
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
