package problem.easy.p198;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Answer {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Solution_1().rob(nums));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/01/06
 * time 100.00% _
 * mem 89.82% _
 *
 * DP
 */
class Solution {
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) return nums[0];
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[0];
        dp[1][1] = nums[1];

        for (int i = 2; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 1][0]) + nums[i];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}

/**
 * @author caoPhoenix
 * @date 2020/5/29
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了6.52%的用户
 * 【动态规划】
 * 其实和上面的解法一样，但是 dp 的时候没必要判断 dp[i] 是否“偷了 i”
 * 因为每次迭代的时候，是以“偷了 i”的情况考虑的，而是否“偷了 i”则是由每次的 max 来决定
 * 内存优化上，还可以不用dp数组只用两个值
 */
class Solution_1 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // dp[i] 表示前 i 间的最大金额
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }
}