import java.util.HashMap;

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
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int prev = map.get(s.charAt(s.length() - 1));
        int res = prev;

        for (int i = s.length() - 2; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            res += curr * ((curr < prev) ? -1 : 1);
            prev = curr;
        }

        return res;
    }
}
