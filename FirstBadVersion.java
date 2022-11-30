/**
 * Leetcode problem #278, First Bad Version
 * https://leetcode.com/problems/first-bad-version
 */
public class FirstBadVersion {

    public static int bad = 4;
    public static void main(String[] args) {
        int n = 5;
        int startPos = firstBadVersion(n);
        System.out.println(startPos);
    }

    public static boolean isBadVersion(int i) {
        return (i >= bad);
    }

    public static int firstBadVersion(int n) {
        int start = 1, end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }
}
