import java.util.HashMap;
import java.util.HashSet;

/**
 * Leetcode problem #1207, Unique Number of Occurrences
 * https://leetcode.com/problems/unique-number-of-occurrences/
 */
public class UniqueNumberOccurences {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1, 1, 3 };
        System.out.println(uniqueOccurences(arr));
    }

    public static boolean uniqueOccurences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>(map.values());

        return map.size() == set.size();
    }
}