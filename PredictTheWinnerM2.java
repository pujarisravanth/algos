/**
 * Leetcode problem #486, Predict the Winner
 * https://leetcode.com/problems/predict-the-winner/
 */
public class PredictTheWinnerM2 {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 233, 7 };
        System.out.println(predictTheWinner(nums));
    }

    public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int diff = maxDiff(nums, 0, n - 1, dp);
        return diff >= 0;
    }

    public static int maxDiff(int[] nums, int left, int right, int[][] dp) {
        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        if (left == right) {
            return nums[left];
        }

        int leftDiff = nums[left] - maxDiff(nums, left + 1, right, dp);
        int rightDiff = nums[right] - maxDiff(nums, left, right - 1, dp);
        dp[left][right] = Math.max(leftDiff, rightDiff);

        return dp[left][right];
    }
}
