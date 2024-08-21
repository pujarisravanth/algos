/**
 * Leetcode problem #567, Permutation in String
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int l1 = s1.length();

        int[] arr1 = new int[26];
        for (char c : s1.toCharArray()) {
            arr1[c - 'a']++;
        }

        int[] arr2 = new int[26];
        char[] charArr2 = s2.toCharArray();

        int l = 0;
        for (int r = 0; r < charArr2.length; r++) {
            int index = charArr2[r] - 'a';
            arr2[index]++;

            /**
             * If the value is arr2 is more than arr1: ie. either not exists or more
             * characters of the type, with the left slider updating the arr1 till it
             * matches, or reaches r
             */
            while (arr2[index] > arr1[index] && l <= r) {
                arr2[charArr2[l] - 'a']--;
                l++;
            }

            if ((r - l + 1) == l1) {
                return true;
            }
        }

        return false;
    }
}
