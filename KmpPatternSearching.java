/**
 * KMP Pattern Searching
 * Also known as Knuth-Morris-Pratt algorithm
 */
public class KmpPatternSearching {

    public static void main(String[] args) {
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";

        int[] lps = ComputeLpsArray.computeLpsArray(pattern);
        KmpSearch(text, pattern, lps);
    }

    public static void KmpSearch(String text, String pattern, int[] lps) {
        int i = 0;
        int j = 0;

        int n = text.length();
        int m = pattern.length();

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            }
        }
    }
}
