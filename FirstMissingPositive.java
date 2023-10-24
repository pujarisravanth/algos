/**
 * Leetcode problem #41, First Missing Positive
 * https://leetcode.com/problems/first-missing-positive
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = { 1, -2, 3, 14, 5, 6, 7, 18 };
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        boolean contains = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                contains = true;
            }
            if (nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        if (!contains)
            return 1;

        for (int i = 0; i < nums.length; i++) {
            // To avoid duplicate number updates
            int val = Math.abs(nums[i]);
            nums[val - 1] = -1 * Math.abs(nums[val - 1]);
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                return i + 1;
        }

        return nums.length + 1;
    }
}
