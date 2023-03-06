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
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] - mid - 1 < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // return arr[r] + k - (arr[r] - r - 1)
        return k + r + 1;
    }
}
