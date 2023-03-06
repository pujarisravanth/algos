import java.util.Arrays;

/**
 * Leetcode #16, 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/description/
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(diff)) {
                    diff = sum - target;
                }
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return target + diff;
    }
}
