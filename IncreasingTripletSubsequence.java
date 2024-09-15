/**
 * Leetcode problem #334, Increasing Triplet Subsequence
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 1, 5, 0, 4, 6 };
        System.out.println(increasingTriplet(nums));
    }

    static boolean increasingTriplet(int[] nums) {
        int first_num = Integer.MAX_VALUE;
        int second_num = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= first_num)
                first_num = n;
            else if (n <= second_num)
                second_num = n;
            else
                return true;
        }

        return false;
    }
}
