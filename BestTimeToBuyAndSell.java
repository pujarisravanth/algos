/**
 * Leetcode problem #121, Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */
public class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {
        int start = Integer.MAX_VALUE, max = 0;
        for (int i : prices) {
            if (start > i) {
                start = i;
            }
            max = Math.max(i - start, max);
        }

        return max;
    }
}
