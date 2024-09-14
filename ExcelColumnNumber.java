/**
 * Leetcode problem #171, Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelColumnNumber {

    public static void main(String[] args) {
        String s = "AB";
        System.out.println(titleToNumber(s));
    }

    public static int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }

        return res;
    }
}
