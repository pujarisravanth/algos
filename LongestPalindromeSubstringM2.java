import java.util.Arrays;

/**
 * Leetcode problem #5, Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Brute force way of computing LPS array.
 */
public class LongestPalindromeSubstringM2 {

    public static void main(String[] args) {
        String s = "abcbabcbabcba";
        int[] lps = computeLPS(s);
        System.out.println(Arrays.toString(lps));
    }

    public static int[] computeLPS(String s) {
        int n = s.length();
        int lps[] = new int[2 * n + 1];
        lps[0] = 0;

        for (int i = 1; i < 2 * n + 1; i++) {
            lps[i] = (i % 2 == 1) ? -1 : 0;
            int a = (i - 1) / 2;
            int b = i / 2;
            while (a >= 0 && b < n && s.charAt(a) == s.charAt(b)) {
                lps[i] += 2;
                a--;
                b++;
            }
        }

        return lps;
    }
}
