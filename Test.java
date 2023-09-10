import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

    }

    public static int testFunc(String s) {
        int len = 0;
        int start = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            len = Math.max(i - start + 1, len);
        }

        return len;
    }
}
