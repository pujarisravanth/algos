/**
 * Leetcode problem #486, Predict the Winner
 * https://leetcode.com/problems/predict-the-winner/
 */
public class PredictTheWinnerM1 {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 233, 7 };
        System.out.println(predictTheWinner(nums));
    }

    public static boolean predictTheWinner(int[] nums) {
        int diff = maxDiff(nums, 0, nums.length - 1);
        return diff >= 0;
    }

    public static int maxDiff(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int leftDiff = nums[left] - maxDiff(nums, left + 1, right);
        int rightDiff = nums[right] - maxDiff(nums, left, right - 1);

        return Math.max(leftDiff, rightDiff);
    }
}
