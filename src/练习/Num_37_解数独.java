package 练习;

/**
 * @author mufan
 * @date 2020/5/5
 */
public class Num_37_解数独 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (!isValid(board, row, col, k)) {
                        continue;
                    }
                    board[row][col] = k;
                    if (solve(board)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char k) {
        for (int i = 1; i <= 9; i++) {
            //校验行上是否合法
            if (board[row][i] != '.' && board[row][i] == k) {
                return false;
            }
            //校验列上是否合法
            if (board[i][col] != '.' && board[i][col] == k) {
                return false;
            }
            //校验九宫格是否合法3*(row/3),3*(col/3)确定在哪个九宫格上
            char c = board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3];
            if (c != '.' && c == k) {
                return false;
            }
        }
        return true;
    }
}
