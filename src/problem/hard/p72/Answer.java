package problem.hard.p72;

/**
 * 72. 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class Answer {
}

/**
 * DP
 */
class Solution {
    public int minDistance(String word1, String word2) {
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        int m = chs1.length;
        int n = chs2.length;
        //
        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 0;
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        // 长度为i的word1，变成长度为j的word2，所需的步数
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (chs1[i] == chs2[j])
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Integer.min(dp[i - 1][j - 1],
                            Integer.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}