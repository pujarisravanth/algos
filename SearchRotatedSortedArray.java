/**
 * Leetcode problem #33, Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[0]) {
                if (nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
