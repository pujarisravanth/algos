import java.util.Arrays;

/**
 * Leet code problem, #875: Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/
 */

public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int right = Arrays.stream(piles).max().getAsInt();
        int left = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatInTime(piles, h, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canEatInTime(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / k;
            if (pile % k != 0) {
                hours++;
            }
        }

        return hours <= h;
    }
}
