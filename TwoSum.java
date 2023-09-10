import java.util.HashMap;

/**
 * Leet code problem
 * https://leetcode.com/problems/two-sum/
 * with exactly one solution
 * 
 * Using: hash map
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = { 2, 11, 7, 15 };
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int complement = target - nums[i];
            if (hmap.containsKey(complement)) {
                return new int[] { hmap.get(complement), i };
            }
            hmap.put(nums[i], i);
        }

        return new int[] {};
    }
}
