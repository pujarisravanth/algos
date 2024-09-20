import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode problem #271, Encode and Decode Strings
 * https://leetcode.com/problems/encode-and-decode-strings/
 * 
 * Using Escaping, '/' as escape character, with delimiter as "/:"
 */
public class EncodeAndDecodeStringsM1 {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(Arrays.asList("Hello", "World"));

        Codec codec = new Codec();
        String encodedString = codec.encode(strs);
        System.out.println(encodedString);
        System.out.println(codec.decode(encodedString));
    }

    static class Codec {

        // Encode list of strings to a single string
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();

            for (String s : strs) {
                sb.append(s.replace("/", "//")).append("/:");
            }

            return sb.toString();
        }

        // Decodes a single string to a list of strings
        public List<String> decode(String s) {
            List<String> strs = new ArrayList<>();

            StringBuilder sb = new StringBuilder();
            int len = s.length();
            int i = 0;

            while (i < s.length()) {
                // If we encounter delimiter /:
                if (i + 1 < len && s.charAt(i) == '/' && s.charAt(i + 1) == ':') {
                    strs.add(sb.toString());

                    sb = new StringBuilder();
                    i += 2;
                } else if (i + 1 < len && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                    sb.append('/');
                    i += 2;
                } else {
                    sb.append(s.charAt(i));
                    i++;
                }
            }

            return strs;
        }
    }
}