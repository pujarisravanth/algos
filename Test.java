import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        int rooms = minMeetingRooms(intervals);
        System.out.println(rooms);
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (n1, n2) -> n1[0] - n2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek() < intervals[i][0]) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }

        return pq.size();
    }

}
