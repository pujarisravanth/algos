import java.util.Arrays;

/**
 * Leetcode problem #1480, Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array
 */
public class RunningSum {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        int[] res = runningSum(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];

        for(int i=1; i<nums.length; i++) {
            res[i] = res[i-1] + nums[i];
        }

        return res;
    }
}
