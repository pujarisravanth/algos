/**
 * Leet code problem, #14: Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");

        if (strs.length == 0) {
            return sb.toString();
        }

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }

        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }
}