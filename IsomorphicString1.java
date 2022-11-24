import java.util.Arrays;

/**
 * Leetcode problem #205, Isomorphic Strings (Approach 1)
 * https://leetcode.com/problems/isomorphic-strings
 */
public class IsomorphicString1 {
    public static void main(String[] args) {
        String s = "paper", t = "title";
        boolean isIsomorphic = isIsomorphic(s, t);
        System.out.println(isIsomorphic);
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr1 = new int[256], arr2 = new int[256];
        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);
        
        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);

            if (arr1[c1] == -1 && arr2[c2] == -1) {
                arr1[c1] = c2;
                arr2[c2] = c1;
            }
            else if (arr1[c1] != c2 || arr2[c2] != c1) return false;
        }

        return true;
    }
}
