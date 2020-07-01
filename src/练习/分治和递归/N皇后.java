package 练习.分治和递归;

import java.util.*;

/**
 * @author mufan
 * @date 2020/3/28
 */
public class N皇后 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> lie = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        char[][] board = new char[n][n];
        //先将左右的各自填充点
        for (char[] charArray : board) {
            Arrays.fill(charArray, '.');
        }
        dfs(board, 0, res, lie, pie, na);
        return res;
    }

    private static void dfs(char[][] board, int row, List<List<String>> res, Set<Integer> lie, Set<Integer> pie, Set<Integer> na) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(String.valueOf(chars));
            }
            res.add(list);
            return;
        }
        //遍历每一行
        for (int  col = 0;  col < board[row].length; col++) {
            //剪枝，如果遍历的点在lie,pie,na里面则go die
            if (lie.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }
            board[row][col] = 'Q';
            lie.add(col);
            pie.add(row + col);
            na.add(row - col);

            dfs(board, row + 1, res, lie, pie, na);

            board[row][col] = '.';
            lie.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
        }
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
