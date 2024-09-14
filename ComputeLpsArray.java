import java.util.Arrays;

/**
 * LPS - Longest prefix which is also a suffix
 * Used in KMP algorithm
 */
public class ComputeLpsArray {
    
    public static void main(String[] args) {
        String pattern = "AAACAAAAAC";
        int[] lps = computeLpsArray(pattern);
        System.out.println("LPS array: " + Arrays.toString(lps));
    }

    public static int[] computeLpsArray(String pattern) {
        int[] lps = new int[pattern.length()];
        
        int len = 0;
        int i = 1;
        int n = pattern.length();
        lps[0] = 0;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                // For cases like AAACAAAA, when we have to backtrack
                if (len != 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
