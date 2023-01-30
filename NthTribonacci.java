/**
 * Leetcode problem #1137, N-th Tribonacci Number
 * https://leetcode.com/problems/n-th-tribonacci-number/
 */

public class NthTribonacci {
    public static void main(String[] args) {
        int n = 25;
        int res = tribonacci(n);
        System.out.println(res);
    }

    public static int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;

        int i0 = 0, i1 = 1, i2 = 1;
        int res = 0;

        for (int i = 3; i <= n; i++) {
            res = i0 + i1 + i2;
            i0 = i1;
            i1 = i2;
            i2 = res;
        }

        return res;
    }
}
