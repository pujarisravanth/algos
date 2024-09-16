/**
 * Leetcode Problem #724, Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 7, 3, 6, 5, 6 };
        int index = pivotIndex(nums);
        System.out.println(index);
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0, lsum = 0;
        for (int x : nums)
            sum += x;
        for (int i = 0; i < nums.length; i++) {
            if (lsum == (sum - lsum - nums[i]))
                return i;
            lsum += nums[i];
        }

        return -1;
    }
}
