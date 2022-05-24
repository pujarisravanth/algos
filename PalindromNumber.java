public class PalindromNumber {
    public static void main(String[] args) {
        int num = 122111;
        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(int num) {
        if (num < 0 || num != 0 && num % 10 == 0) {
            return false;
        }

        int reverse = 0;
        while (num > reverse) {
            reverse = reverse * 10 + num % 10;
            num = num / 10;
        }

        return num == reverse || num == reverse / 10;
    }
}
