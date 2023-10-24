import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode problem #49, Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * 
 * m: length of strs array
 * n: avg length of each string in strs array
 * Time complexity: O(mn)
 * Space complexity: O(mn)
 */

public class GroupAnagramsM2 {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> res = groupAnagram(strs);
        System.out.println(res);
    }

    public static List<List<String>> groupAnagram(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] hash = new char[26];
            for (char c : str.toCharArray()) {
                hash[c - 'a']++;
            }
            String key = new String(hash);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
