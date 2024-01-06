import java.util.Arrays;

/**
 * Leetcode problem #27, Remove Element
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
        int k = removeElement(nums, 2);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int cnt = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == val) {
                nums[i] = nums[cnt];
                nums[cnt] = val;
                cnt--;
            }
        }

        return cnt + 1;
    }
}
