import java.util.Arrays;

/**
 * Leetcode problem #48, Rotate Image
 * https://leetcode.com/problems/rotate-image/
 * This method uses transpose and then reflect
 */

public class RotateImage2 {
    public static void main(String[] args) {
        int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public static void transpose(int[][] mat) {
        int n = mat.length;
        for (int i=0; i < n; i++) {
            for (int j=i+1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public static void reflect(int[][] mat) {
        int n = mat.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j < n/2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = temp;
            }
        }
    }
}
