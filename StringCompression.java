import java.util.Arrays;

/**
 * Leetcode problem #443, String Compression
 * https://leetcode.com/problems/string-compression/
 */

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = { 'a', 'a', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c' };
        System.out.println(compress(chars));
        System.out.println(Arrays.toString(chars));
    }

    public static int compress(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            int len = 1;
            while (i + len < chars.length && chars[i + len] == chars[i]) {
                len++;
            }
            chars[res++] = chars[i];
            if (len > 1) {
                for (char c : Integer.toString(len).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += len;
        }

        return res;
    }
}
