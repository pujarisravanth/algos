/**
 * Leetcode problem #240, Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * Using Search Space Reduction
 * Time complexity: O(n + m)
 */
public class SearchIn2dMatrix2M1 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }

    // We will start at bottom left
    // If the current value greater than target, we will move up
    // If the current value smaller than target, we will move to right
    static boolean searchMatrix(int[][] matrix, int target) {
        // For this, we can start at any diagonal point.
        int row = matrix.length - 1, col = 0;

        // If we choose other diagonal point, the conditions will be reversed.
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target)
                return true;

            if (matrix[row][col] > target)
                row--;
            else
                col++;
        }
        return false;
    }
}
