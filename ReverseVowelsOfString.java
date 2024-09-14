import java.util.Set;

/**
 * Leetcode problem #345, Reverse Vowels of a String
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowelsOfString {
    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s));
    }

    static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int l = 0, r = arr.length - 1;
        while (l < r) {
            while (l < r && !set.contains(arr[l])) {
                l++;
            }

            while (l < r && !set.contains(arr[r])) {
                r--;
            }

            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }

        return String.valueOf(arr);
    }
}
