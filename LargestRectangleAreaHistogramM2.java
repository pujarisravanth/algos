import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode problem #84, Largest Rectangle In Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Using Stacks
 * Time complexity: O(n)
 */
public class LargestRectangleAreaHistogramM2 {
    public static void main(String[] args) {
        int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }

    static int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int h = st.pop();
                int area = heights[h] * (i - (st.isEmpty() ? -1 : st.peek()) - 1);
                res = Math.max(res, area);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int h = st.pop();
            int area = heights[h] * (heights.length - (st.isEmpty() ? -1 : st.peek()) - 1);
            res = Math.max(res, area);
        }

        return res;
    }
}
