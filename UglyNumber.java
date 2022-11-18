/**
 * Leetcode problem #263, Ugly Number
 * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {
    public static void main(String[] args) {
        int n = 14;
        boolean isUgly = isUgly(n);
        System.out.println(isUgly);
    }

    public static boolean isUgly(int n) {
        if (n <= 0) return false;
        
        for (int divisor : new int[] {2, 3, 5}) {
            n = keepDividingWhenDivisible(n, divisor);
        }

        return n == 1;
    }

    public static int keepDividingWhenDivisible(int n, int divisor) {
        while (n % divisor == 0) {
            n = n / divisor;
        }
        return n;
    }
}
