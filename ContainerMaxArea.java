/**
 * Leetcode problem #11, Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/description/
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ContainerMaxArea {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int max = maxArea(height);
        System.out.println(max);
    }

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;

        while (l < r) {
            int left = height[l], right = height[r];
            max = Math.max(max, Math.min(left, right) * (r - l));

            if (left <= right) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
