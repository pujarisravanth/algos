/**
 * Leetcode problem #74, Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class SearchIn2dMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }

    static boolean binarySearch(int[][] matrix, int target, int low, int high) {
        if (low > high)
            return false;

        int mid = (low + high) / 2;
        int midValue = matrix[mid / matrix[0].length][mid % matrix[0].length];
        if (midValue == target)
            return true;

        if (midValue > target)
            return binarySearch(matrix, target, low, mid - 1);
        return binarySearch(matrix, target, mid + 1, high);
    }
}
