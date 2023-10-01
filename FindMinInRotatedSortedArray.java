/**
 * Leetcode problem #153, Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Time complexity: O(Log(n))
 * Space complexity: O(1)
 */
public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        // Either length is one, or array is not rotated at all
        if (nums.length == 1 || nums[0] < nums[nums.length - 1])
            return nums[0];

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= nums[0]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[r];
    }
}
