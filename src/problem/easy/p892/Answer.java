package problem.easy.p892;

/**
 * 892. 三维形体的表面积
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 */
public class Answer {
    public static void main(String[] args) {
        int[][] grid = {{2,2,2},{2,1,2},{2,2,2}};
        System.out.println(new Solution().surfaceArea(grid));
    }
}

/**
 * 考虑一下遮挡，直接算就行了
 */
class Solution {
    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int N = grid.length;
        int total = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int v = grid[i][j];
                if (v == 0) continue;
                int north = 0, south = 0, west = 0, east = 0;
                north = i < 1 ? v : Integer.max(grid[i][j] - grid[i - 1][j], 0);
                south = i > N - 2 ? v : Integer.max(grid[i][j] - grid[i + 1][j], 0);
                west = j < 1 ? v : Integer.max(grid[i][j] - grid[i][j - 1], 0);
                east = j > N - 2 ? v : Integer.max(grid[i][j] - grid[i][j + 1], 0);
                total = total + north + south + west + east + 2;
            }
        }
        return total;
    }
}