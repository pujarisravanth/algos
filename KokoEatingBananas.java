/**
 * Leet code problem, #875: Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/
 */

public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 10;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1;
        for (int pile: piles) {
            r = Math.max(pile, r);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            int timeTaken = timeSpent(piles, mid);
            if (timeTaken <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

    public static int timeSpent(int[] piles, int k) {
        int total = 0;
        for (int pile: piles) {
            total += (pile - 1) / k + 1;
        }

        return total;
    }
}
