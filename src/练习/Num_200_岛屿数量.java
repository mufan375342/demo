package 练习;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author mufan
 * @date 2020/4/6
 */
public class Num_200_岛屿数量 {

    private char[][] grid;
    private int cols;
    private int rows;
    private boolean[][] marked;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int res = 0;

        rows = grid.length;
        if (rows <= 0) {
            return 0;
        }
        cols = grid[0].length;

        marked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !marked[i][j]) {
                    res++;
                    dfs(i, j);
                }
            }
        }
        return res;

    }

    private void dfs(int i, int j) {
        marked[i][j] = true;
        //得到四个方向的坐标
        for (int k = 0; k < directions.length; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            if (inArea(x, y) && grid[x][y] == '1' && !marked[x][y]) {
                dfs(x, y);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    //----------------------------------------------------------------------------------------------------------------------

    public int numIslandsOfBFS(char[][] grid) {
        this.grid = grid;
        int res = 0;

        rows = grid.length;
        if (rows <= 0) {
            return 0;
        }
        cols = grid[0].length;
        marked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0' || marked[i][j]) {
                    continue;
                }
                res++;
                marked[i][j] = true;
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i * cols + j);
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    int curX = poll / cols;
                    int curY = poll % cols;
                    for (int[] direction : directions) {
                        int newX = curX + direction[0];
                        int newY = curY + direction[1];
                        if (inArea(newX, newY) && !marked[newX][newY] && grid[newX][newY] == '1') {
                            marked[newX][newY] = true;
                            queue.add(newX * cols + newY);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Num_200_岛屿数量 solution = new Num_200_岛屿数量();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = solution.numIslands(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = solution.numIslands(grid2);
        System.out.println(numIslands2);
    }

}
