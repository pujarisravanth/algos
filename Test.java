import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

    }

    public static double testFunc(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n > m)
            testFunc(nums2, nums1);

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int p1 = (start + end) / 2;
            int p2 = (n + m + 1) / 2 - p1;

            int min1 = (p1 == 0) ? Integer.MIN_VALUE : nums1[p1 - 1];
            int max1 = (p1 == n) ? Integer.MAX_VALUE : nums1[p1];

            int min2 = (p2 == 0) ? Integer.MIN_VALUE : nums2[p2 - 1];
            int max2 = (p2 == m) ? Integer.MAX_VALUE : nums2[p2];

            if (min1 <= max2 && min2 <= max1) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(min1, min2) + Math.min(max1, max2)) / 2.0;
                }
                return Math.max(min1, min2);
            } else if (min1 > max2) {
                end = p1 - 1;
            } else {
                start = p1 + 1;
            }
        }

        return 0;
    }
}
