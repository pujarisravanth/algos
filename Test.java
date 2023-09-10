import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
    }

    public static String testFunc(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m)
            return testFunc(b, a);

        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') {
                ++carry;
            }
            if (j > -1 && b.charAt(j) == '1') {
                ++carry;
                j--;
            }

            sb.append((carry % 2 == 1) ? '1' : '0');
            carry /= 2;
        }

        if (carry == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}