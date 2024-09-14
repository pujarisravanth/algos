import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode problem #84, Largest Rectangle In Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Using Stacks, with simple code
 * Time complexity: O(n)
 */
public class LargestRectangleAreaHistogramM3 {
    public static void main(String[] args) {
        int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }

    static int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        int res = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            while (st.size() > 1 && heights[st.peek()] > h) {
                int barHeight = heights[st.pop()];
                res = Math.max(res, barHeight * (i - st.peek() - 1));
            }
            st.push(i);
        }

        return res;
    }
}
