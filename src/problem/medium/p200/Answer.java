package problem.medium.p200;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class Answer {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution_2().numIslands(grid));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/04/20
 * time 6ms 23%
 * mem 42.1MB 6%
 * BFS
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        int count = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] marked = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    marked[i][j] = true;
                    queue.add(new int[]{i, j});
                    count++;    // 发现一块独立大陆
                }
                while (!queue.isEmpty()) {
                    // 把该大陆四邻域的全部标记
                    int[] now = queue.remove();
                    for (int k = 0; k < 4; k++) {
                        int tx = now[0] + dx[k];
                        int ty = now[1] + dy[k];
                        if (tx >= 0 && tx < height && ty >= 0 && ty < width
                                && !marked[tx][ty] && grid[tx][ty] == '1') {
                            marked[tx][ty] = true;
                            queue.add(new int[]{tx, ty});
                        }
                    }
                }
            }
        }
        return count;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/04/20
 * time 2ms 96.16%
 * mem 42.2MB 6.25%
 * DFS 比 BFS 快不少。。
 */
class Solution_2 {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int height;
    int width;
    int count = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return count;
        }
        height = grid.length;
        width = grid[0].length;
        boolean[][] marked = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    System.out.println(i + ", " + j);
                    dfs(i, j, grid, marked);
                    count++;
                }

            }
        }
        return count;
    }

    public void dfs(int x, int y, char[][] grid, boolean[][] marked) {
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx >= 0 && tx < height && ty >= 0 && ty < width
                    && !marked[tx][ty] && grid[tx][ty] == '1') {
                marked[tx][ty] = true;
                dfs(tx, ty, grid, marked);
            }
        }
    }
}