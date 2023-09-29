import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leet code problem #452, Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 * 
 * Time complexity: O(nLogn)
 * Space complexity: O(n)
 */
public class MinArrowsShot {
    public static void main(String[] args) {
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n <= 1)
            return n;

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        for (int[] p : points) {
            queue.add(p);
        }

        int count = 0;
        int[] p = queue.poll();
        int end = p[1];

        while (!queue.isEmpty()) {
            p = queue.poll();
            if (p[0] > end) {
                count++;
                end = p[1];
            }
        }

        return count;
    }
}
