import java.util.Arrays;

/**
 * Leetcode problem #48, Rotate Image
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i < n/2; i++) {
            for (int j=0; j < n-2*i-1; j++) {
                int temp = matrix[i][i+j];
                matrix[i][i+j] = matrix[n-1-i-j][i];
                matrix[n-1-i-j][i] = matrix[n-1-i][n-1-i-j];
                matrix[n-1-i][n-1-i-j] = matrix[i+j][n-1-i];
                matrix[i+j][n-1-i] = temp;
            }
        }
    }
}
