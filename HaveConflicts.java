/**
 * Leetcode problem #2446, Determine if Two Events Have Conflict
 * https://leetcode.com/problems/determine-if-two-events-have-conflict/
 */
public class HaveConflicts {
    public static void main(String[] args) {
        String[] event1 = { "01:15", "02:00" };
        String[] event2 = { "02:00", "03:00" };
        System.out.println(haveConflicts(event1, event2));
    }

    public static boolean haveConflicts(String[] event1, String[] event2) {
        if (event1[0].compareTo(event2[0]) > 0)
            return haveConflicts(event2, event1);
        return event1[1].compareTo(event2[0]) >= 0;
    }
}
