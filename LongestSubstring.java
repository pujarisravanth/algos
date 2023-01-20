import java.util.HashMap;

/**
 * Leet code problem - Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Given a string, find the length of the longest substring without repeating
 * characters.
 */

public class LongestSubstring {

    public static void main(String[] args) {
        String s = "pwwkpew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        int len = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        while (end < len) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            max = Math.max(max, end - start + 1);
            end++;
        }

        return max;
    }
}