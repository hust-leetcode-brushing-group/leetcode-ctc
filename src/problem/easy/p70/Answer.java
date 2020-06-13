package problem.easy.p70;

public class Answer {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(2));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/13
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗 :36.4 MB, 在所有 Java 提交中击败了5.66%的用户
 * 【动态规划】
 * 这个内存消耗很玄学，明明把数组优化成了三个int，结果不降反增
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        int i_1 = 1;
        int i_2 = 1;
        int dp = i_1;
        for (int i = 2; i <= n; i++) {
            dp = i_1 + i_2;
            i_2 = i_1;
            i_1 = dp;
        }
        return dp;
    }
}