/**
 * Leetcode problem #605, Can Place Flowers
 * https://leetcode.com/problems/can-place-flowers/
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = new int[] { 1, 0, 0, 0, 1 };
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = -2, r = 0;
        for (; r <= flowerbed.length; r++) {
            int val = (r == flowerbed.length) ? 0 : flowerbed[r];
            if (val == 1) {
                l = r;
                continue;
            }

            if (r - l == 3) {
                n--;
                l += 2;
                if (n == 0)
                    return true;
            }
        }

        return n <= 0;
    }
}
