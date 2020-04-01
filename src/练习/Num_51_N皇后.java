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
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        Set<Integer> lie = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        char[][] board = new char[n][n];
        for (char[] arr : board) {
            Arrays.fill(arr, '.');
        }
        //0:代表的是row
        dfs(0, board, lie, pie, na, list);
        return list;
    }

    private static void dfs(int row, char[][] board, Set<Integer> lie, Set<Integer> pie, Set<Integer> na, List<List<String>> list) {
        if (row == board.length) {
            List<String> li = new ArrayList<>();
            for (char[] arr : board) {
                li.add(String.valueOf(arr));
            }
            list.add(li);
            return;
        }
        for (int col = 0; col < board[row].length; col++) {
            if (pie.contains(row + col) || na.contains(row - col) || lie.contains(col)) {
                continue;
            }
            lie.add(col);
            pie.add(row + col);
            na.add(row - col);
            board[row][col] = 'Q';

            dfs(row + 1, board, lie, pie, na, list);

            board[row][col] = '.';
            lie.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
        }
    }
}
