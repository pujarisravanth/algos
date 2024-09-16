/**
 * Leetcode problem #Longest Subarray of 1's After Deleting One Element
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
public class LongestSubArrayOfOnesAfterDeleting {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        System.out.println(longestSubarray(nums));
    }

    static int longestSubarray(int[] nums) {
        if (nums.length == 1)
            return 0;

        int l = 0;
        int zeroes_count = 0;
        int len = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0)
                zeroes_count++;

            while (l < r && zeroes_count > 1) {
                if (nums[l] == 0)
                    zeroes_count--;
                l++;
            }

            // Not r - l + 1, becuase we must delete one element
            len = Math.max(len, r - l);
        }

        return len;
    }
}
