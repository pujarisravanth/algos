/**
 * Leetcode problem #1071, Greatest Common Divisor of Strings
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/description
 */
public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        String str1 = "ABABAB", str2 = "ABAB";
        System.out.println(gcdOfStrings(str1, str2));
    }

    static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    static int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }
}
