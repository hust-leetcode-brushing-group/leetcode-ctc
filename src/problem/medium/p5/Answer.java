package problem.medium.p5;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Answer {
    public static void main(String[] args) {
        String s = "cccccccc";

        System.out.println(new Solution().longestPalindrome(s));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/21
 * 执行用时 :120 ms, 在所有 Java 提交中击败了39.34% 的用户
 * 内存消耗 :50.8 MB, 在所有 Java 提交中击败了5.35%的用户
 *
 * 很离谱，一道常规动归，五个月之前练过这题，这次居然从一开始思路就错的。。。
 * 一定要想好动归数组的含义以及递推式！一维动归行不通就加一维！
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chs = s.toCharArray();
        // chs[i][j] 是否是回文串
        int[][] dp = new int[chs.length][chs.length];
        int max = 1;
        int mi = 0, mj = 0;

        // 上三角矩阵，递推公式：由左下角确定
        for (int i = 0; i < chs.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < chs.length - 1; i++) {
            dp[i][i + 1] = chs[i] == chs[i + 1] ? 2 : 0;
            if (dp[i][i + 1] > max) {
                max = dp[i][i + 1];
                mi = i;
                mj = i + 1;
            }
        }
        // 遍历顺序由对角线往右上角
        for (int step = 2; step < chs.length; step++) {
            for (int i = 0; i < chs.length - step; i++) {
                int j = i + step;
                if (dp[i + 1][j - 1] == 0) dp[i][j] = 0;
                else dp[i][j] = chs[i] == chs[j] ? dp[i + 1][j - 1] + 2 : 0;
                // System.out.println(i+","+j+","+dp[i][j]);
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    mi = i;
                    mj = j;
                }
            }
        }
        return s.substring(mi, mj + 1);
    }
}