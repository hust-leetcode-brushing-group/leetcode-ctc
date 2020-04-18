package problem.medium.p542;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * https://leetcode-cn.com/problems/01-matrix/
 */
public class Answer {
}

/**
 * 多源广搜
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return null;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] update = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(update[i], -1);
        }
        // 从所有的0开始做多源广搜
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    update[i][j] = 0;
                }
            }
        }
        // 上下左右
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] site = queue.remove();
                for (int d = 0; d < 4; d++) {
                    int tmpx = site[0] + dx[d];
                    int tmpy = site[1] + dy[d];
                    if (tmpx >= 0 && tmpx < m && tmpy >= 0 && tmpy < n
                            && update[tmpx][tmpy] == -1) {
                        queue.add(new int[]{tmpx, tmpy});
                        update[tmpx][tmpy] = step;
                    }
                }
                size--;
            }
            step++;
        }
        return update;
    }
}