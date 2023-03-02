import java.util.Stack;

/**
 * Leetcode problem #42, Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * Usind stack solution
 */
public class TrappingRainWaterM2 {
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int total = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int block = st.pop();
                if (st.isEmpty())
                    break;

                int bound = Math.min(height[st.peek()], height[i]);
                total += (bound - height[block]) * (i - st.peek() - 1);
            }
            st.push(i);
        }

        return total;
    }
}
