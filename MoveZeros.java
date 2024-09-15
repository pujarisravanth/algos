import java.util.Arrays;

/**
 * Leetcode problem #283, Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void moveZeroes(int[] nums) {
        int l = 0, r = 0;
        for (; r < nums.length; r++) {
            if (nums[r] != 0) {
                nums[l] = nums[r];
                l++;
            }
        }

        for (; l < nums.length; l++) {
            nums[l] = 0;
        }
    }
}
