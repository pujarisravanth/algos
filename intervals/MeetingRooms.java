package intervals;

import java.util.Arrays;

/**
 * Leetcode problem #252, Meeting Rooms
 * https://leetcode.com/problems/meeting-rooms/
 */
public class MeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0)
            return true;

        // sort accoring to end time
        Arrays.sort(intervals, (n1, n2) -> Integer.compare(n1[1], n2[1]));
        int endTime = 0;

        for (int[] n : intervals) {
            if (endTime > n[0])
                return false;
            endTime = n[1];
        }

        return true;
    }
}