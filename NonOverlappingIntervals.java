import java.util.Arrays;

/**
 * Leetcode problems #435, Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(eraseOverlappingIntervals(intervals));
    }

    public static int eraseOverlappingIntervals(int[][] intervals) {
        if (intervals.length <= 1)
            return 0;

        Arrays.sort(intervals, (n1, n2) -> n1[1] - n2[1]);
        int count = 1, endTime = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (endTime <= intervals[i][0]) {
                count++;
                endTime = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}
