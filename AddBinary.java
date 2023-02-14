public class AddBinary {
    public static void main(String[] args) {
        String a = "111", b = "11";
        String res = addBinary(a, b);
        System.out.println(res);
    }

    public static String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) return addBinary(b, a);

        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;

        for (int i = n-1; i > -1; i--) {
            if (a.charAt(i) == '1') ++carry;
            if (j > -1 && b.charAt(j--) == '1') ++carry;

            sb.append((carry % 2 == 1) ? '1': '0');
            carry /= 2;
        }

        if (carry == 1) sb.append('1');

        return sb.reverse().toString();
    }
}
