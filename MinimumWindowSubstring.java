/**
 * Leetcode problem #76, MinimumWindowSubstring
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANCD";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    static String minWindow(String s, String t) {
        int[] tMap = new int[58];
        for (char c : t.toCharArray()) {
            tMap[c - 'A']++;
        }

        int[] sMap = new int[58];
        int l = 0, dup = 0;
        int n = t.length(), max = Integer.MAX_VALUE;
        String res = "";
        char[] arr = s.toCharArray();
        for (int r = 0; r < arr.length; r++) {
            sMap[arr[r] - 'A']++;

            // If the count in sMap more than tMap, then it is a duplicate
            if (sMap[arr[r] - 'A'] > tMap[arr[r] - 'A']) {
                dup++;
            }

            while (l <= r && sMap[arr[l] - 'A'] > tMap[arr[l] - 'A']) {
                sMap[arr[l] - 'A']--;
                l++;
                dup--;
            }

            if (r - l + 1 - dup == n && r - l + 1 < max) {
                max = r - l + 1;
                res = s.substring(l, r + 1);
            }
        }

        return res;
    }
}