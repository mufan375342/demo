package 练习;

import java.util.*;

/**
 * @author mufan
 * @date 2020/4/1
 */
public class Num_51_N皇后 {
    /**
     * 思路:解决N皇后的问题,首先想到的是DFS,深度优先搜索,枚举每一行中的列,然后pie和na之间不能有皇后
     * pie和na的状态需要记录,然后寻找下一个皇后,需要进行回溯
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        Set<Integer> lie = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        char[][] board = new char[n][n];
        for (char[] charArray : board) {
            Arrays.fill(charArray, '.');
        }
        dfs(board, 0, res, lie, pie, na);
        return res;
    }

    private static void dfs(char[][] board, int row, List<List<String>> res, Set<Integer> lie, Set<Integer> pie, Set<Integer> na) {
        //terminator
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(String.valueOf(chars));
            }
            res.add(list);
            return;
        }
        //process
        //剪枝
        for (int col = 0; col < board[row].length; col++) {
            if (lie.contains(col) || pie.contains((row + col)) || na.contains((row - col))) {
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

}
