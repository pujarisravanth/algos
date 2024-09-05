import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode problem #57, Insert Interval
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = new int[] { 4, 8 };

        int[][] resIntervals = insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(resIntervals));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<>();
        int n = intervals.length, i = 0;

        // intervals before the range
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Intervals in the range
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // Intervals after the range
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
