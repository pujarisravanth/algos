import java.util.Deque;
import java.util.LinkedList;

/**
 * Leetcode problem #649, Dota2 Senate
 * https://leetcode.com/problems/dota2-senate/description/
 * Using one Queue, with floating ban count
 */
public class Dota2SenateM2 {
    public static void main(String[] args) {
        String senate = "RRDDD";
        System.out.println(predictPartyVictory(senate));
    }

    static String predictPartyVictory(String senate) {
        int rCount = 0, dCount = 0;

        // Keeping count of how many to ban, when encountered
        int rFloatingBan = 0, dFloatingBan = 0;

        Deque<Character> q = new LinkedList<>();
        for (char c : senate.toCharArray()) {
            if (c == 'R')
                rCount++;
            else
                dCount++;
            q.add(c);
        }

        while (rCount > 0 && dCount > 0) {
            char c = q.poll();
            if (c == 'R') {
                if (rFloatingBan > 0) {
                    rFloatingBan--;
                    rCount--;
                } else {
                    dFloatingBan++;
                    q.add('R');
                }
            } else {
                if (dFloatingBan > 0) {
                    dFloatingBan--;
                    dCount--;
                } else {
                    rFloatingBan++;
                    q.add('D');
                }
            }
        }

        return (rCount > 0) ? "Radiant" : "Dire";
    }
}
