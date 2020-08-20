package 每日一题;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author mufan
 * @date 2020/8/20
 */
public class Num_529_扫雷游戏 {

    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                continue;
            }
            if (board[tx][ty] == 'M') {
                cnt++;
            }
        }
        if (cnt > 0) {
            board[x][y] = (char) (cnt + '0');
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E') {
                    continue;
                }
                dfs(board, tx, ty);
            }
        }
    }

    private void bfs(char[][] board, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            x = pos[0];
            y = pos[1];
            int cnt = 0;
            for (int i = 0; i < 8; i++) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                    continue;
                }
                if (board[tx][ty] == 'M') {
                    cnt++;
                }
            }
            if (cnt > 0) {
                board[x][y] = (char) (cnt + '0');
            } else {
                board[x][y] = 'B';
                for (int i = 0; i < 8; i++) {
                    int tx = x + dirX[i];
                    int ty = y + dirY[i];
                    if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E' || visited[tx][ty]) {
                        continue;
                    }
                    queue.offer(new int[]{tx, ty});
                    visited[tx][ty] = true;
                }
            }
        }
    }
}
