/**
 * Leetcode problem #84, Largest Rectangle In Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Using Brute Force Method
 * Time complexity: O(n^2)
 */
public class LargestRectangleAreaHistogramM1 {
    public static void main(String[] args) {
        int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }

    static int largestRectangleArea(int[] heights) {
        int res = 0;

        // For each point we will find left and right boundaries
        for (int i = 0; i < heights.length; i++) {
            int area = (getRightBoundary(heights, i) - getLeftBoundary(heights, i) - 1) * heights[i];
            res = Math.max(res, area);
        }

        return res;
    }

    static int getLeftBoundary(int[] heights, int target) {
        int i = target - 1;
        for (; i >= 0; i--) {
            if (heights[i] < heights[target])
                break;
        }
        return i;
    }

    static int getRightBoundary(int[] heights, int target) {
        int i = target + 1;
        for (; i < heights.length; i++) {
            if (heights[i] < heights[target])
                break;
        }
        return i;
    }
}
