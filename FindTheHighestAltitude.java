/**
 * Leetcode problem #1732, Find the Highest Altitude
 * https://leetcode.com/problems/find-the-highest-altitude/
 */
public class FindTheHighestAltitude {
    public static void main(String[] args) {
        int[] gain = new int[] { -5, 1, 5, 0, -7 };
        System.out.println(largestAltitude(gain));
    }

    static int largestAltitude(int[] gain) {
        int highest = 0, alt = 0;
        for (int n : gain) {
            alt += n;
            highest = Math.max(highest, alt);
        }
        return highest;
    }
}
