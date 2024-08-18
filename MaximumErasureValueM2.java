import java.util.HashSet;

/**
 * Leetcode problem #1695, Maximum Erasure Value
 * https://leetcode.com/problems/maximum-erasure-value/
 */
public class MaximumErasureValueM2 {
    public static void main(String[] args) {
        int[] nums = new int[] { 4, 2, 4, 5, 6 };
        System.out.println(maximumUniqueSubarray(nums));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int start = 0, currSum = 0, resSum = 0;
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            while (numSet.contains(nums[i])) {
                currSum -= nums[start];
                numSet.remove(nums[start]);
                start++;
            }

            currSum += nums[i];
            numSet.add(nums[i]);
            resSum = Math.max(currSum, resSum);
        }

        return resSum;
    }
}
