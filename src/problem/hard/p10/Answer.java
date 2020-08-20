package problem.hard.p10;

/**
 * 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class Answer {
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "a"));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/8/20
 * 执行用时：5 ms, 在所有 Java 提交中击败了70.88% 的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了36.04% 的用户
 * 【动态规划】剑指offer.19
 */
class Solution {
    public boolean isMatch(String s, String p) {
        // s的前i个字母和p的前j个字母是否匹配
        int s_len = s.length(), p_len = p.length();
        boolean[][] dp = new boolean[s_len + 1][p_len + 1];
        // 初始条件
        // dp[0][j] = dp[i][0] = false;
        dp[0][0] = true;
        for (int j = 1; j < p_len; j++) {
            if (p.charAt(j) == '*') dp[0][j + 1] = dp[0][j - 1];
        }

        // 递推
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') { // 匹配
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*' && j >= 1) { // 不匹配但 p[j] =
                    // '*'，且按照p的模式应该有 j ≥ 1
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i][j + 1];
                    }
                    dp[i + 1][j + 1] |= dp[i + 1][j - 1];
                }
            }
        }

        return dp[s_len][p_len];
    }
}