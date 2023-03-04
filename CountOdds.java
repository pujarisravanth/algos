/**
 * Leetcode problem #1523, Count Odd Numbers in an Interval Range
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 */
public class CountOdds {
    public static void main(String[] args) {
        int cnt = countOdds(3, 7);
        System.out.println(cnt);
    }

    public static int countOdds(int low, int high) {
        int cnt = (high - low) / 2;
        return (low % 2 == 1 || high % 2 == 1) ? cnt + 1 : cnt;
    }
}
