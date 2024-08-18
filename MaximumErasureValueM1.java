import java.util.HashMap;

/**
 * Leetcode problem #1695, Maximum Erasure Value
 * https://leetcode.com/problems/maximum-erasure-value/
 */
public class MaximumErasureValueM1 {
    public static void main(String[] args) {
        int[] nums = new int[] { 4, 2, 4, 5, 6 };
        System.out.println(maximumUniqueSubarray(nums));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int startSum = 0, sum = 0, res = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                startSum = Math.max(map.get(nums[i]), startSum);
            }
            sum += nums[i];
            map.put(nums[i], sum);
            res = Math.max(sum - startSum, res);
        }

        return res;
    }
}
