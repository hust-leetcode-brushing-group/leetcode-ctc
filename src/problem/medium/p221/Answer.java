package problem.medium.p221;

/**
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class Answer {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(new Solution_2().maximalSquare(matrix));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/01/06
 * time 87.81% _
 * mem 88.89% _
 *
 * DP[i][j] 表示以下标i,j为右下角的最大的正方形边长
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        int max = 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(dp[i][0], max);
        }
        for (int j = 0; j < col; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(dp[0][j], max);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] - '0' == 0)
                    dp[i][j] = 0;
                else    // 理解状态转移方程
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/08
 * 执行用时：6 ms
 * 内存消耗：42.8 MB
 *
 * 时隔 5 个月，又碰到了这题，写出了一模一样的代码。。
 */
class Solution_2 {
    public int maximalSquare(char[][] matrix) {
        if (null == matrix || 0 == matrix.length || 0 == matrix[0].length)
            return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        // 计算 dp 的过程中记录全局最大值
        int max = 0;

        // dp[i][j]表示以 (i,j)为右下角的最大正方形边长
        int[][] dp = new int[height][width];

        for (int i = 0; i < height; i++) {
            dp[i][0] = matrix[i][0] - '0';
            if (dp[i][0] == 1) max = 1;
        }
        for (int j = 0; j < width; j++) {
            dp[0][j] = matrix[0][j] - '0';
            if (dp[0][j] == 1) max = 1;
        }

        // dp[i][j] 依赖于左、上、左上方的值
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (matrix[i][j] == '1') {
                    // 为什么是最小值？
                    // 只有以这三个点为右下角的正方形中最小的一个，才能保证能够扩充到以(i,j)为右下角的正方形
                    dp[i][j] = Integer.min(Integer.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Integer.max(max, dp[i][j]);
                } else dp[i][j] = 0;
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }
        return max * max;
    }
}
