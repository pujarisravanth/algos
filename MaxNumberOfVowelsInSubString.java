/**
 * Leetcode problem #1456, Maximum Number of Vowels in a SubString
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
public class MaxNumberOfVowelsInSubString {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    static int maxVowels(String s, int k) {
        boolean[] map = new boolean[26];
        for (char c : "aeiou".toCharArray()) {
            map[c - 'a'] = true;
        }

        char[] arr = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (map[arr[i] - 'a'])
                cnt++;
        }

        int res = cnt;
        for (int i = k; i < arr.length; i++) {
            if (map[arr[i - k] - 'a'])
                cnt--;

            if (map[arr[i] - 'a']) {
                cnt++;
                res = Math.max(res, cnt);
            }
        }

        return res;
    }
}
