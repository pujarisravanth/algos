import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode #15, 3Sum
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = threeSum(nums);

        System.out.println(res.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            if (nums[i] > 0)
                break;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    list.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                }
            }
        }

        return list;
    }
}
