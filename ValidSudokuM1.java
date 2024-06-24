import java.util.HashSet;

/**
 * Leetcode problem #36, Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudokuM1 {
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int n = 9;

        HashSet<Character>[] rowSet = new HashSet[n];
        HashSet<Character>[] colSet = new HashSet[n];
        HashSet<Character>[] boxSet = new HashSet[n];

        for(int i = 0; i < n; i++) {
            rowSet[i] = new HashSet<Character>();
            colSet[i] = new HashSet<Character>();
            boxSet[i] = new HashSet<Character>();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                char val = board[r][c];

                if (val == '.') {
                    continue;
                }

                if (rowSet[r].contains(val)) {
                    return false;
                }
                rowSet[r].add(val);

                if (colSet[c].contains(val)) {
                    return false;
                }
                colSet[c].add(val);

                int idx = (r / 3) * 3 + (c / 3);
                if (boxSet[idx].contains(val)) {
                    return false;
                }
                boxSet[idx].add(val);
            }
        }

        return true;
    }
}
