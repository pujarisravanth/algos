import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Leetcode problem #2390, Removing Stars From a String
 * https://leetcode.com/problems/removing-stars-from-a-string/
 */
public class RemoveStarsFromString {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    static String removeStars(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                st.pop();
            } else {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
