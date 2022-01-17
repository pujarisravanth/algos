/**
 * Leetcode Problem #9: Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 * 
 * Solution: we can reverse the number and compare it with the original number.
 * But we don't need to reverse full number, we can compare the first half with.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int num = 121;
        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(int num) {
        /**
         * if the number is negative, it is not a palindrome
         * if the last digit is 0, and the number is not 0, it is not a palindrome
         */
        if (num < 0 || (num != 0 && num % 10 == 0)) {
            return false;
        }

        int reversed = 0;
        while (num > reversed) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }

        /**
         * We need to remove last digit if it is a odd number. for example 12321, num =
         * 12 and reversed = 123. For even case, we don't need to remove last digit, for
         * example 2112, num = 21 and reversed = 21
         */
        return num == reversed || num == reversed / 10;
    }
}
