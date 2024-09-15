/**
 * Leetcode problem #643, Maximum Average Subarray I
 * https://leetcode.com/problems/maximum-average-subarray-i/
 */
public class MaxAverageSubArray {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    static double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        double res = Integer.MIN_VALUE * 1.0;
        for (int i = 0; i < k - 1; i++) {
            sum += nums[i];
        }
        for (int i = k - 1; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum * 1.0 / k);
            sum -= nums[i - k + 1];
        }

        return res;
    }
}
