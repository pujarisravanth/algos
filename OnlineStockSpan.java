import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode problem #901, Online Stock Span
 * https://leetcode.com/problems/online-stock-span/
 */
public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner ss = new StockSpanner();
        System.out.println(ss.next(100));
        System.out.println(ss.next(80));
        System.out.println(ss.next(60));
        System.out.println(ss.next(70));
        System.out.println(ss.next(60));
        System.out.println(ss.next(75));
        System.out.println(ss.next(85));
    }

    static class StockSpanner {
        Deque<int[]> st;
        int index;

        public StockSpanner() {
            index = 1;
            st = new ArrayDeque<>();
        }

        public int next(int price) {
            while (!st.isEmpty() && st.peek()[0] <= price) {
                st.pop();
            }
            int res = st.isEmpty() ? index : index - st.peek()[1];
            st.push(new int[] { price, index });
            index++;

            return res;
        }
    }
}