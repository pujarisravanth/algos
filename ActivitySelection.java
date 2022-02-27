
/** 
 * Select maximum number of activities that can be done by a sinlge person
 */

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    public int first;
    public int second;

    Pair() {
    }

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

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
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.second - p2.second;
            }
        });

        for (int i = 0; i < start.length; i++) {
            pq.add(new Pair(start[i], finish[i]));
        }

        int activity_count = 1;
        Pair p = pq.poll();
        int end = p.second;

        while (!pq.isEmpty()) {
            p = pq.poll();

            // Take the pair whose start time is less than before end time
            if (p.first >= end) {
                activity_count++;
                end = p.second;
            }
        }

        return activity_count;
    }
}
