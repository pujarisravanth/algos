import java.util.Arrays;

/**
 * Leetcode problem #238, Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] res = productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefixArr = new int[n];
        prefixArr[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixArr[i] = nums[i - 1] * prefixArr[i - 1];
        }

        int[] postfixArr = new int[n];
        postfixArr[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            postfixArr[i] = nums[i + 1] * postfixArr[i + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < n; i++) {
            res[i] = prefixArr[i] * postfixArr[i];
        }

        return res;
    }
}
