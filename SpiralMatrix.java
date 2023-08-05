import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public static void main(String[] args) {
    int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
    List<Integer> res = spiralOrder(matrix);
    System.out.println(res);
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    int rows = matrix.length;
    int cols = matrix[0].length;

    int up = 0, down = rows - 1, left = 0, right = cols - 1;

    while (res.size() < rows * cols) {
      for (int i = left; i <= right; i++) {
        res.add(matrix[up][i]);
      }

      for (int i = up + 1; i <= down; i++) {
        res.add(matrix[i][right]);
      }

      if (up != down) {
        for (int i = right - 1; i >= left; i--) {
          res.add(matrix[down][i]);
        }
      }

      if (left != right) {
        for (int i = down - 1; i > up; i--) {
          res.add(matrix[i][left]);
        }
      }

      up++;
      down--;
      left++;
      right--;
    }

    return res;
  }
}
