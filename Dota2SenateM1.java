import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode problem #649, Dota2 Senate
 * https://leetcode.com/problems/dota2-senate/description/
 * Using two Queues
 */
public class Dota2SenateM1 {
    public static void main(String[] args) {
        String senate = "RRDDDD";
        System.out.println(predictPartyVictory(senate));
    }

    static String predictPartyVictory(String senate) {
        char[] arr = senate.toCharArray();
        int n = senate.length();

        Deque<Integer> rq = new ArrayDeque<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R')
                rq.add(i);
            else
                dq.add(i);
        }

        while (!rq.isEmpty() && !dq.isEmpty()) {
            int r = rq.poll();
            int d = dq.poll();

            if (r < d)
                rq.add(r + n);
            else
                dq.add(d + n);
        }

        return rq.isEmpty() ? "Dire" : "Radiant";
    }
}
