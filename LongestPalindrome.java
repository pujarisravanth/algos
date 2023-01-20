/**
 * Leetcode problem #409, Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "abccccdd";
        int length = longestPalindrome(str);
        System.out.println(length);
    }

    public static int longestPalindrome(String s) {
        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int res = 0;
        for (int i : count) {
            res += (i / 2) * 2;
        }

        return (res == s.length()) ? res : res + 1;
    }
}
