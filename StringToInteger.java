/**
 * Leetcode problem #8, String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {
    public static void main(String[] args) {
        String s = "1337c0d3";
        System.out.println(myAtoi(s));
    }

    static int myAtoi(String s) {
        int sign = 1;
        int res = 0;
        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i < n && s.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        int max_div = Integer.MAX_VALUE / 10;
        int max_remainder = Integer.MAX_VALUE % 10;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int x = s.charAt(i) - '0';

            // Basically to avoid long res variable
            if (res > max_div || (res == max_div && x > max_remainder)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = (res * 10) + x;
            i++;
        }

        return res * sign;
    }
}
