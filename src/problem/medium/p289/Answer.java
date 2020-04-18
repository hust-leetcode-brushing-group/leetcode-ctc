package problem.medium.p289;

import java.util.Arrays;

/**
 * 289. 生命游戏
 * https://leetcode-cn.com/problems/game-of-life/
 */
public class Answer {
    public static void main(String[] args) {
        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new Solution().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] result = new int[m][n];

        // 顺时针方向
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    int temp_x = i + dx[k];
                    int temp_y = j + dy[k];
                    if (temp_x < 0 || temp_x >= m || temp_y < 0 || temp_y >= n)
                        continue;
                    if (board[temp_x][temp_y] == 1) live++;
                }   // 计算活细胞数
                // System.out.println("i = " + i + ", j = " + j + ", live =" + live);
                if (board[i][j] == 1) {
                    if (live < 2 || live > 3)
                        result[i][j] = 0; // 活细胞死亡
                    else {
                        result[i][j] = 1; // 活细胞存活
                    }
                } else if (board[i][j] == 0) {
                    if (live == 3)
                        result[i][j] = 1; // 死细胞复活
                }
            }
        }
        for (int i = 0; i < m; i++) {
            board[i] = Arrays.copyOf(result[i], n);
        }
    }
}

/**
 * 原地算法
 * 用其他数字定义新状态
 */
class Solution_2 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // 顺时针方向
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        // 定义活细胞死亡标记-1， 死细胞复活标记2；
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    int temp_x = i + dx[k];
                    int temp_y = j + dy[k];
                    if (temp_x < 0 || temp_x >= m || temp_y < 0 || temp_y >= n)
                        continue;
                    if (board[temp_x][temp_y] == 1 || board[temp_x][temp_y] == -1) live++;
                }   // 计算活细胞数
                // System.out.println("i = " + i + ", j = " + j + ", live =" + live);
                if (board[i][j] == 1) {
                    if (live < 2 || live > 3)
                        board[i][j] = -1; // 活细胞死亡
                    else {
                        board[i][j] = 1; // 活细胞存活
                    }
                } else if (board[i][j] == 0) {
                    if (live == 3)
                        board[i][j] = 2; // 死细胞复活
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] < 1 ? 0 : 1;
            }
        }
    }
}