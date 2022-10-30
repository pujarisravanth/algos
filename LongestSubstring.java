import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem, #3 Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String str = "pwwkew";
        int len = lengthOfLongestSubString(str);
        System.out.println(len);
    }

    public static int lengthOfLongestSubString(String s) {
        int length = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            length = Math.max(length, i - start + 1);
        }

        return length;
    }
}