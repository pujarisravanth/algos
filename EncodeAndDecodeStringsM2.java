import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode problem #271, Encode and Decode Strings
 * https://leetcode.com/problems/encode-and-decode-strings/
 * 
 * Using Chunk Transfer Encoding, prepending the length of the string with
 * delimiter
 * eg: For [Hello, World] ==> 5/:Hello5/:World as encode
 */

public class EncodeAndDecodeStringsM2 {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(Arrays.asList("Hello", "World"));

        Codec codec = new Codec();
        String encodedString = codec.encode(strs);
        System.out.println(encodedString);
        System.out.println(codec.decode(encodedString));
    }
}

class Codec {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append("/:").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            // Get delimiter position from i
            int delim = s.indexOf("/:", i);
            // Get length of string that gonna follow
            int len = Integer.parseInt(s.substring(i, delim));
            // Getting the actual string
            String str = s.substring(delim + 2, delim + len + 2);
            strs.add(str);
            i = delim + 2 + len;
        }

        return strs;
    }
}
