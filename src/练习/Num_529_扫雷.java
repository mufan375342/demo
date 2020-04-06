package 练习;

import sun.security.pkcs11.wrapper.CK_AES_CTR_PARAMS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author mufan
 * @date 2020/4/6
 */
public class Num_529_扫雷 {
    /**
     * DFS
     * 1.定义8个方向位
     * 2.如果点击的点是雷直接改变返回
     * 3.如果点击的点八个方向有雷存在,则将该点变为1直接返回
     * 4.如果点击的点八个方向没有雷，则进行DFS扩散
     */
    private int rows;
    private int cols;

    public char[][] updateBoard(char[][] board, int[] click) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
        this.rows = board.length;
        this.cols = board[0].length;

        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        //判断8个方向位是否有雷
        int num = isHasM(directions, board, click);
        if (num > 0) {
            board[x][y] = (char) num;
            return board;
        }
        board[x][y] = 'B';
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && board[newX][newY] == 'E') {
                int[] nextClick = {newX, newY};
                updateBoard(board, nextClick);
            }
        }
        return board;
    }

    private int isHasM(int[][] directions, char[][] board, int[] click) {
        int res = 0;
        for (int[] direction : directions) {
            int x = direction[0];
            int y = direction[1];
            int newX = x + click[0];
            int newY = y + click[1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && board[newX][newY] == 'M') {
                res++;
            }
        }
        return res;
    }

    public char[][] updateBoard1(char[][] board, int[] click) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
        this.rows = board.length;
        this.cols = board[0].length;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(click[0], click[1]));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
            } else if (board[x][y] == 'E') {
                int[] tep = {x, y};
                int num = isHasM(directions, board, tep);
                if (num > 0) {
                    board[x][y] = (char) (num + '0');
                } else {
                    board[x][y] = 'B';
                    for (int[] dir : directions) {
                        int newX = x + dir[0];
                        int newY = y + dir[1];
                        if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                            queue.add(new Node(newX, newY));
                        }
                    }
                }
            }
        }
        return board;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        Num_529_扫雷 test = new Num_529_扫雷();
        char[][] chars = test.updateBoard1(board, click);
        System.out.println(123);
    }

}
