public class Test {

    public static void main(String[] args) {
        String pat = "AABAACAADAABAAABAA";
        String txt = "AABA";

        search(pat, txt);
    }

    public static void search(String pat, String txt) {
        int l1 = pat.length();
        int l2 = txt.length();

        for (int i = 0, j = l2 - 1; j < l1; ) {
            if (pat.substring(i, j + 1).equals(txt)) {
                System.out.printf("Pattern found at %d\n", i);
            }
            
            i++;
            j++;
        }
    }
}