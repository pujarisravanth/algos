import java.util.HashMap;

/**
 * Leet code problem
 * https://leetcode.com/problems/two-sum/
 * with always unique solution exists
 * need not to be a sorted array
 * 
 * Using; HashMap
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = { 2, 11, 7, 15 };
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (hmap.containsKey(target - nums[i])) {
                res[0] = hmap.get(target - nums[i]);
                res[1] = i;
                break;
            }
            hmap.put(nums[i], i);
        }

        return res;
    }
}
