
/**
 * Optimize the movement, by deleting unnecessary instructions, while mainting
 * the same destination
 * ex: URDR ==> RR, RUDRL ==> R
 */
public class CharacterReprogramming {

    public static void main(String[] args) {
        String s = "RUDRL";
        System.out.println(getMaxDeletions(s));
    }

    private static int getMaxDeletions(String s) {
        int countU = 0, countR = 0, countD = 0, countL = 0;

        for (char c : s.toCharArray()) {
            if (c == 'U')
                countU++;
            else if (c == 'D')
                countD++;
            else if (c == 'R')
                countR++;
            else if (c == 'L')
                countL++;
        }

        int netVertical = Math.abs(countU - countD);
        int netHorizontal = Math.abs(countR - countL);

        return s.length() - netHorizontal - netVertical;
    }
}
