/**
 * Leet code problem #167, Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * with always unique solution exists
 * Sorted in ascending order
 * 
 * Using: two pointer
 */

public class TwoSumSortedArray {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[] { l + 1, r + 1 };
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[2];
    }
}
