/**
 * Leetcode problem #240, Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * Using Divide and Conquer Approach
 * Time complexity: O(nlog(n))
 */
public class SearchIn2dMatrix2M2 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        return searchRec(matrix, target, 0, matrix[0].length - 1, 0, matrix.length - 1);
    }

    // Out of four quadrants (won't be equal quadrants):
    // 2 will be eleminated and 2 will be selected
    static boolean searchRec(int[][] matrix, int target, int left, int right, int up, int down) {
        // If the matrix is out of bounds
        if (left > right || up > down)
            return false;
        // Or is the value/target is out of range of the matrix.
        // i.e lesser than smallest or grater than largest
        else if (matrix[up][left] > target || matrix[down][right] < target)
            return false;

        int mid = (left + right) / 2;

        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target)
                return true;
            row++;
        }

        return searchRec(matrix, target, mid + 1, right, up, row - 1)
                || searchRec(matrix, target, left, mid - 1, row, down);
    }
}
