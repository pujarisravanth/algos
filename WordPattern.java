import java.util.HashMap;

/**
 * Leetcode problem #290, Word Pattern
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {
    public static void main(String[] args) {
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String s = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";

        boolean res = wordPattern(pattern, s);
        System.out.println(res);
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] strArr = s.split(" ");

        if (pattern.length() != strArr.length) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < strArr.length; i++) {
            char c = pattern.charAt(i);
            String w = strArr[i];

            if (!map1.containsKey(c)) {
                map1.put(c, i);
            }

            if (!map2.containsKey(w)) {
                map2.put(w, i);
            }

            if (!map1.get(c).equals(map2.get(w))) {
                System.out.printf("%c : %d, %s : %d", c, map1.get(c), w, map2.get(w));
                System.out.println();
                return false;
            }
        }

        return true;
    }
}
