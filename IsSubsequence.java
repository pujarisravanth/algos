/**
 * Leetcode problem #392, Is Subsequence
 * https://leetcode.com/problems/is-subsequence
 * 
 * Time complexity: O(n)
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        boolean isSubsequence = isSubsequence(s, t);
        System.out.println(isSubsequence);
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }

        return i == s.length();
    }
}
