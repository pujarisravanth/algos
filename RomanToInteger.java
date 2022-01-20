/**
 * Leet Code Problem #13: Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 */

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int res = 0;
        int prev = getIntValue(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int curr = getIntValue(s.charAt(i));
            if (curr > prev) {
                res -= prev;
            } else {
                res += prev;
            }
            prev = curr;
        }
        res += prev;

        return res;
    }

    private static int getIntValue(char c) {
        switch (c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            default:
                return 1;
        }
    }
}
