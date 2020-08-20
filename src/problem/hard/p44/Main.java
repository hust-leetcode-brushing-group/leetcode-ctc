package problem.hard.p44;

/**
 * 44. 通配符匹配
 * https://leetcode-cn.com/problems/wildcard-matching/
 */
public class Main {
    public static void main(String[] args) {

    }
}

/**
 * @author caoPhoenix
 * @date 2020/8/20
 * 执行用时：35 ms, 在所有 Java 提交中击败了63.62% 的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了87.79% 的用户
 * 【动态规划】和jzoffer.19类似。
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int s_len = s.length(), p_len = p.length();
        boolean[][] dp = new boolean[s_len + 1][p_len + 1];

        // dp[i][0] = false;
        dp[0][0] = true;
        for (int j = 0; j < p_len; j++) {
            dp[0][j + 1] = p.charAt(j) == '*' && dp[0][j];
        }

        for (int i = 0; i < s_len; i++) {
            for (int j = 0; j < p_len; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
                }
            }
        }

        return dp[s_len][p_len];
    }
}