/**
 * Leetcode problem #50, Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 */

public class Power {
    public static void main(String[] args) {
        double res = myPow(2.0, -2147483648);
        System.out.println(res);
    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            return (1/x) * myPow(1/x, -(n+1));
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }
}
