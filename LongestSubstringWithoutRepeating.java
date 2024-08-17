import java.util.HashMap;

/**
 * Leet code problem - Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Using: hashmap, Sliding window
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = 0;
        int start = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(s.charAt(i) + 1, start);
            }
            map.put(s.charAt(i), i);
            len = Math.max(i - start + 1, len);
        }

        return len;
    }
}