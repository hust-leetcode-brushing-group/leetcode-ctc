package problem.medium.p1162;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. 地图分析
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 */
public class Answer {
    public static void main(String[] args) {
        int grid[][] = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(new Solution().maxDistance(grid));
    }
}

class Solution {

    private int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};// 上下左右

    private int N;

    public int maxDistance(int[][] grid) {
        this.N = grid.length;
        int step = BFS(grid);
        return step == 0 ? -1 : step;
    }

    private boolean checkLocation(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private int BFS(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for (boolean[] arr : visited) {
            Arrays.fill(arr, false);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] now = queue.remove();
                for (int k = 0; k < 4; k++) {
                    int temp_x = now[0] + direct[k][0];
                    int temp_y = now[1] + direct[k][1];
                    if (checkLocation(temp_x, temp_y) && !visited[temp_x][temp_y] && grid[temp_x][temp_y] == 0) {
                        queue.add(new int[]{temp_x, temp_y});
                        visited[temp_x][temp_y] = true;
                    }
                }
                size--;
            }
            step++;
        }
        return step - 1;
    }
}
