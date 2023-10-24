import java.util.HashMap;

/**
 * Leetcode problem #205, Isomorphic Strings (Approach 2)
 * https://leetcode.com/problems/isomorphic-strings
 */
public class IsomorphicStringM2 {
    public static void main(String[] args) {
        String s = "paper", t = "title";
        boolean isIsomorphic = isIsomorphic(s, t);
        System.out.println(isIsomorphic);
    }

    public static boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }

    public static String transformString(String s) {
        StringBuilder builder = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);

            if (!map.containsKey(c1)) {
                map.put(c1, i);
            }

            builder.append(Integer.toString(map.get(c1)));
            builder.append(" ");
        }

        return builder.toString();
    }
}
