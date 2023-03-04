import java.util.ArrayList;

/**
 * Leetcode problem #264, Ugly Number II
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }

    public static int nthUglyNumber(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int two = 0, three = 0, five = 0;

        list.add(1);
        while (list.size() < n) {
            int m2 = list.get(two) * 2;
            int m3 = list.get(three) * 3;
            int m5 = list.get(five) * 5;

            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);

            if (min == m2)
                two++;
            if (min == m3)
                three++;
            if (min == m5)
                five++;
        }

        return list.get(n - 1);
    }
}
