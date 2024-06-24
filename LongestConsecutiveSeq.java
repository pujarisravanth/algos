import java.util.HashSet;

/**
 * Leetcode problem #128, Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int currLength = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    currLength++;
                }

                maxLength = Math.max(maxLength, currLength);
            }
        }

        return maxLength;
    }
}
