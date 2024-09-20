import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode problem #394, Decode String
 * https://leetcode.com/problems/decode-string/
 */
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]2[bd]";
        System.out.println(decodeString(s));
    }

    static String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();

        int k = 0;
        StringBuilder currentString = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                k = 0;

                stringStack.push(currentString);
                currentString = new StringBuilder();
            } else if (c == ']') {
                StringBuilder sb = stringStack.pop();
                for (int i = countStack.pop(); i > 0; i--) {
                    sb.append(currentString);
                }
                currentString = sb;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}
