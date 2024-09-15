import java.util.Arrays;

/**
 * Leetcode problem #1679, Max Number of K-Sum Pairs
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 * Using Sorting and two pointers
 * 
 * Hashmap approach should be faster, I don't know why leetcode is hsowing this
 * is faster
 */
public class MaxNumberOfKSumPairsM2 {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 1, 3, 4, 3, 2 };
        int k = 6;
        System.out.println(maxOperations(nums, k));
    }

    static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int cnt = 0;
        while (l < r) {
            int val = nums[l] + nums[r];
            if (val > k) {
                r--;
            } else if (val < k) {
                l++;
            } else {
                l++;
                r--;
                cnt++;
            }
        }
        return cnt;
    }
}
