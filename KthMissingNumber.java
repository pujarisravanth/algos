/**
 * Leetcode #1539, Kth Missing Positive Number
 * https://leetcode.com/problems/kth-missing-positive-number/
 */
public class KthMissingNumber {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        System.out.println(findKthpositive(arr, 5));
    }

    public static int findKthpositive(int[] arr, int k) {
        int len = 0, prev = 0;
        for (int num : arr) {
            if (num != prev + 1) {
                if (len + num - prev - 1 >= k) {
                    break;
                }
                len += num - prev - 1;
            }
            prev = num;
        }

        return prev + (k - len);
    }
}
