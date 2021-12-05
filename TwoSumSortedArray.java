/**
 * Leet code problem
 * with always unique solution exists
 * Sorted in ascending order
 * 
 * Using: two pointer
 */

public class TwoSumSortedArray {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = TwoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] TwoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] res = new int[2];

        while (i < j) {
            if (nums[i] + nums[j] == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            }

            if (nums[i] + nums[j] > target)
                j--;
            else
                i++;
        }

        return res;
    }
}
