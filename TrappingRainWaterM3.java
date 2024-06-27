/**
 * Leetcode problem #42, Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * Usind two pinter solution
 */
public class TrappingRainWaterM3 {
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lMax = 0, rMax = 0;
        int total = 0;

        while (l < r) {
            if (height[l] <= height[r]) {
                lMax = Math.max(lMax, height[l]);
                total += lMax - height[l];
                l++;
            } else {
                rMax = Math.max(rMax, height[r]);
                total += rMax - height[r];
                r--;
            }
        }

        return total;
    }
}
