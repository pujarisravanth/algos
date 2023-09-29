import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        System.out.println(testFunc(points));
    }

    public static int testFunc(int[][] points) {
        int n = points.length;
        if (n == 0)
            return 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        for (int[] a : points) {
            queue.add(a);
        }

        int count = 1;
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
