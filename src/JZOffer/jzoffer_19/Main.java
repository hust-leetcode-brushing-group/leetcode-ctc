package JZOffer.jzoffer_19;

/**
 * 剑指 Offer 19. 正则表达式匹配
 * https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 */
public class Main {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(new Solution_1().isMatch(s, p));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/8/20
 * 执行用时：5 ms, 在所有 Java 提交中击败了53.61% 的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了59.67% 的用户
 * 【动态规划】
 */
class Solution {
    public boolean isMatch(String s, String p) {
        // s的前i个字母和p的前j个字母是否匹配
        int s_len = s.length(), p_len = p.length();
        boolean[][] dp = new boolean[s_len + 1][p_len + 1];
        // 初始条件
        // dp[i][0] = false;
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


/**
 * @author caoPhoenix
 * @date 2020/8/20
 * 执行用时：91 ms, 在所有 Java 提交中击败了11.23% 的用户
 * 内存消耗：40.3 MB, 在所有 Java 提交中击败了5.20% 的用户
 * 【递归】递归思路比较简单，但是速度比动归还是慢了不少
 */
class Solution_1 {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (p.length() == 1) return s.length() == 1 && cmpFirst(s, p);

        if (p.charAt(1) == '*') {
            if (s.length() == 0) return isMatch(s, p.substring(2));
            else if (cmpFirst(s, p))
                return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            else return isMatch(s, p.substring(2));
        } else {
            if (s.length() == 0) return false;
            else if (cmpFirst(s, p))
                return isMatch(s.substring(1), p.substring(1));
            else return false;
        }
    }

    private boolean cmpFirst(String s, String p) {
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }
}