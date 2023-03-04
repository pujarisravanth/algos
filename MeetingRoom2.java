import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode problem #253, Meeting Rooms II
 * https://leetcode.com/problems/meeting-rooms-ii/description/
 */
public class MeetingRoom2 {
    public static void main(String[] args) {
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        int rooms = minMeetingRooms(intervals);
        System.out.println(rooms);
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(intervals.length, (n1, n2) -> n1 - n2);
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] n1, int[] n2) {
                return n1[0] - n2[0];
            }
        });

        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }

            minHeap.add(intervals[i][1]);
        }

        return minHeap.size();
    }
}
