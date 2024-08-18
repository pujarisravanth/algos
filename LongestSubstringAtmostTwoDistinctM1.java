import java.util.Collections;
import java.util.HashMap;

/**
 * Leetcode problem #159, Longest Subsstring with Atmost Two Distinctive
 * Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * Directly jumping to next start indexing with the help of hashmaps
 */
public class LongestSubstringAtmostTwoDistinctM1 {
    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0;
        int len = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);

            if (map.size() == 3) {
                // Deleting leftmost character
                int left_idx = Collections.min(map.values());
                map.remove(s.charAt(left_idx));

                start = left_idx + 1;
            }

            len = Math.max(i - start + 1, len);
        }

        return len;
    }
}
