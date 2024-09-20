import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode problem #933, Number of Recent Calls
 * https://leetcode.com/problems/number-of-recent-calls/
 */
public class NumberOfRecentCalls {
    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }

    static class RecentCounter {
        Deque<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            while (!queue.isEmpty() && (t - queue.peek()) > 3000) {
                queue.poll();
            }
            queue.add(t);
            return queue.size();
        }
    }
}
