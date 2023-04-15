import java.util.Arrays;

public class LpsArray {
    public static void main(String[] args) {
        String s = "AAACAAAA";
        int[] lps = computeLps(s);
        System.out.println(Arrays.toString(lps));
    }

    public static int[] computeLps(String s) {
        int[] lps = new int[s.length()];
        if (lps.length < 1)
            return lps;

        int prevLps = 0, i = 1;
        while (i < lps.length) {
            if (s.charAt(i) == s.charAt(prevLps)) {
                lps[i++] = lps[prevLps++] + 1;
            } else if (prevLps == 0) {
                lps[i++] = 0;
            } else {
                prevLps = lps[prevLps - 1];
            }
        }

        return lps;
    }
}
