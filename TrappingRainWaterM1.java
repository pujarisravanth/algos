/**
 * Leetcode problem #42, Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * Usind DP solution
 */
public class TrappingRainWaterM1 {
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int n = height.length;

        // Finding lmax and water that can be stored with lmax
        int lMax = 0;
        int[] lSum = new int[n];
        for (int i = 0; i < n; i++) {
            lMax = Math.max(lMax, height[i]);
            lSum[i] = lMax - height[i];
        }

        // Finding rmax and water that can be stored with rmax
        int rMax = 0;
        int[] rSum = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rMax = Math.max(rMax, height[i]);
            rSum[i] = rMax - height[i];
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(lSum[i], rSum[i]);
        }

        return total;
    }
}
