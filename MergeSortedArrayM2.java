import java.util.Arrays;

/**
 * Leetcode problem #88, Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArrayM2 {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = new int[] { 2, 5, 6 };
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr = m + n - 1;
        m = m - 1;
        n = n - 1;

        while (m >= 0 && n >= 0) {
            if (n < 0)
                break;

            if (m < 0 || nums1[m] < nums2[n]) {
                nums1[curr] = nums2[n--];
            } else {
                nums1[curr] = nums1[m--];
            }

            curr--;
        }
    }
}
