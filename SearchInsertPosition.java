/**
 * Leetcode problem #35, Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int res = searchInsert(nums, 2);
        System.out.println(res);
    }

    public static int searchInsert(int[] nums, int target) {
        int mid, l = 0, r = nums.length - 1;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return (nums[l] < target) ? l + 1 : l;
    }
}
