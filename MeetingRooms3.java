import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Leetode problem #2402, Meeting Rooms III
 * https://leetcode.com/problems/meeting-rooms-iii/
 */

public class MeetingRooms3 {
    public static void main(String[] args) {
        int[][] meetings = { { 48, 49 }, { 22, 30 }, { 13, 31 }, { 31, 46 }, { 37, 46 }, { 32, 36 }, { 25, 36 },
                { 49, 50 }, { 24, 34 }, { 6, 41 } };
        int rooms = 4;

        System.out.println(mostBooked(rooms, meetings));
    }

    public static int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.endTime == b.endTime)
                return a.room - b.room;
            return a.endTime - b.endTime;
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        int[] res = new int[n];

        for (int[] meeting : meetings) {
            while (!minHeap.isEmpty() && minHeap.peek().endTime <= meeting[0]) {
                queue.add(minHeap.poll().room);
            }

            if (!queue.isEmpty()) {
                int room = queue.poll();
                minHeap.add(new Pair(meeting[1], room));
                res[room]++;
            } else {
                Pair lastMeeting = minHeap.poll();
                minHeap.add(new Pair(lastMeeting.endTime + meeting[1] - meeting[0], lastMeeting.room));
                res[lastMeeting.room]++;
            }
        }

        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (res[maxIndex] < res[i]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}

class Pair {
    int endTime;
    int room;

    Pair(int end, int room) {
        this.endTime = end;
        this.room = room;
    }
}