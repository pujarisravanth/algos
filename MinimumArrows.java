import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leet code problem #452. Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */

public class MinimumArrows {

    public static void main(String[] args) {
        int[][] points = { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 0) {
            return 0;
        }

        // Sort by finish time
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (a[1] > b[1]) ? 1 : -1;
            }
        });

        for (int i = 0; i < n; i++) {
            pq.add(points[i]);
        }

        int arrows_count = 1;
        int[] p = pq.poll();
        int end = p[1];

        while (!pq.isEmpty()) {
            p = pq.poll();

            if (p[0] > end) {
                arrows_count++;
                end = p[1];
            }
        }

        return arrows_count;
    }
}
