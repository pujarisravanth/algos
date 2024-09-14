/**
 * Leetcode problem #242, Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnangram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean isValidAnagram = isAnagram(s, t);
        System.out.println(isValidAnagram);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int i : charCount) {
            if (i != 0)
                return false;
        }

        return true;
    }
}
