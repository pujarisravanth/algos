public class Test {

    public static void main(String[] args) {
        String a = "111", b = "11";
        System.out.println(testFunc(a, b));
    }

    public static String testFunc(String a, String b) {
        int n = a.length();
        int m = b.length();

        if (n < m) {
            testFunc(b, a);
        }

        int carry = 0;
        int j = m - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i > -1; i--) {
            int sum = carry;
            if (a.charAt(i) == '1')
                sum++;
            if (j > -1 && b.charAt(j--) == '1')
                sum++;

            sb.append(sum % 2 == 0 ? '0' : '1');
            carry = sum / 2;
        }

        if (carry == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}
