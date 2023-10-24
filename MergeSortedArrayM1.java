import java.util.Arrays;

/**
 * Leetcode problem #88, Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArrayM1 {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 2 };
        int[] nums2 = new int[] { 0 };
        merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr = m + n - 1;
        m = m - 1;
        n = n - 1;

        while (m >= 0 || n >= 0) {
            if (m < 0 || (n >= 0 && nums2[n] >= nums1[m])) {
                nums1[curr] = nums2[n--];
            } else {
                nums1[curr] = nums1[m--];
            }
            curr--;
        }
    }
}
