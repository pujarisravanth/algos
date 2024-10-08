import java.util.Arrays;

public class Test {
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
