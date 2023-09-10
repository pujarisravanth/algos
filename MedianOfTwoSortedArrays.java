/**
 * Leet code problem #4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Time complexity: O(log(min(m, n)))
 * Space complexity: O(1)
 */

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2, 4 };

        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int start = 0;
        int end = m;

        while (start <= end) {
            int partition1 = (start + end) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            int minNums1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int maxNums1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int minNums2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int maxNums2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if (minNums1 <= maxNums2 && minNums2 <= maxNums1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(minNums1, minNums2) + Math.min(maxNums1, maxNums2)) / 2.0;
                }
                return Math.max(minNums1, minNums2);
            } else if (minNums1 > maxNums2) {
                end = partition1 - 1;
            } else {
                start = partition1 + 1;
            }
        }

        return 0;
    }
}
