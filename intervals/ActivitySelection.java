package intervals;

import java.util.PriorityQueue;

/**
 * Count how many activites can be done
 */
public class ActivitySelection {

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int finish[] = { 2, 4, 6, 7, 9, 10 };

        System.out.println(findMaxActivities(start, finish));
    }

    public static int findMaxActivities(int[] start, int[] finish) {
        if (start.length == 0) {
            return 0;
        }

        // Sort by finish time
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> (n1[1] > n2[1]) ? 1 : -1);

        for (int i = 0; i < start.length; i++) {
            pq.add(new int[] { start[i], finish[i] });
        }

        int activity_count = 1;
        int[] current = pq.poll();
        int end = current[1];

        while (!pq.isEmpty()) {
            current = pq.poll();

            // Take the pair whose start time is less than before end time
            if (end <= current[0]) {
                activity_count++;
                end = current[1];
            }
        }

        return activity_count;
    }
}
