import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode problem #49, Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * Time complexity of this is O(mnlog(n)), where m: length of strs array, n: avg length of each string in strs array
 */
public class GroupAnagrams1 {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> res = groupAnagram(strs);
        System.out.println(res);
    }

    public static List<List<String>> groupAnagram(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            
            List<String> value = map.get(sortedStr);
            if (value == null) {
                value = new ArrayList<>();
            }
            value.add(str);
            map.put(sortedStr, value);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
