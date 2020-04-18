package problem.medium.p221;

/**
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class Answer {
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
