import java.util.Arrays;

/**
 * Similar to leetcode problem #901, Online Stock Span
 * https://leetcode.com/problems/online-stock-span/
 * But in here, we should return the spanning array
 * Since this is a Monotonic stack problem, we don't need to use stack
 */
public class OnlineStockSpan2 {
    public static void main(String[] args) {
        int[] prices = new int[] { 100, 80, 60, 70, 60, 75, 85, 100 };
        int[] res = findStockSpan(prices);
        System.out.println(Arrays.toString(res));
    }

    static int[] findStockSpan(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        int maxPrice = 0;

        for (int i = 0; i < n; i++) {
            if (prices[i] > maxPrice) {
                res[i] = i + 1;
                maxPrice = prices[i];
                continue;
            }

            int days = 1;
            while ((i - days) >= 0 && prices[i] > prices[i - days]) {
                days += res[i - days];
            }
            res[i] = days;
        }

        return res;
    }
}
