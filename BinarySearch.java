/**
 * Leetcode problem #704, Binary Search
 * https://leetcode.com/problems/binary-search/
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[] { -1, 0, 3, 5, 9, 12 };
        int target = 9;

        int index = search(nums, target);
        System.out.println(index);
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static int binarySearch(int[] nums, int target, int low, int high) {
        if (low > high)
            return -1;

        int m = low + (high - low) / 2;

        if (nums[m] == target)
            return m;
        if (nums[m] > target)
            return binarySearch(nums, target, low, m - 1);

        return binarySearch(nums, target, m + 1, high);
    }
}
