/**
 * Leetcode problem #28, Find the Index of the First Occurrence in a String
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * Using KMP pattern searching
 */
public class PatternMatching {
    public static void main(String[] args) {
        String haystack = "ABABDABACDABABCABAB";
        String needle = "ABABCABAB";
        int index = strStr(haystack, needle);
        System.out.println(index);
    }

    public static int strStr(String haystack, String needle) {
        int[] lps = computeLps(needle);
        int i = 0, j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }

            if (j == needle.length()) {
                return i - j;
            }
        }

        return -1;
    }

    public static int[] computeLps(String s) {
        int[] lps = new int[s.length()];
        int prevLps = 0, i = 1;
        lps[0] = 0;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(prevLps)) {
                prevLps++;
                lps[i] = prevLps;
                i++;
            } else {
                if (prevLps == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prevLps = lps[prevLps - 1];
                }
            }
        }

        return lps;
    }

}
