/**
 * Leetcode problem #1004, Max Consecutive Ones III
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }

    static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int zeros_count = 0;
        int max_count = 0;
        while (r < nums.length) {
            if (nums[r] == 0)
                zeros_count++;

            while (l <= r && zeros_count > k) {
                if (nums[l] == 0)
                    zeros_count--;
                l++;
            }

            max_count = Math.max(max_count, r - l + 1);
            r++;
        }

        return max_count;
    }
}
