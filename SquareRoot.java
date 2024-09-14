/**
 * Leetcode problem #69, Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 */
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(mySqrt(600));
    }

    public static int mySqrt(int x) {
        if (x < 2)
            return x;

        int l = 2, r = x / 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long res = (long) mid * mid;

            if (res == x)
                return mid;

            if (res > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }
}
