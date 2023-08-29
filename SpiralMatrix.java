import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode problem #54, Spriral Matrix
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        List<Integer> res = spiralOrder(matrix);
        System.out.println(res);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        // boundaries
        int up = 0, left = 0, right = cols - 1, down = rows - 1;

        while (list.size() < rows * cols) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            up++;

            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (right > left && up < down) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
                down--;

                for (int i = down; i >= up; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}
