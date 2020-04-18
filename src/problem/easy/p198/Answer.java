package problem.easy.p198;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Answer {
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
		if(len == 1) return nums[0];
		int[][] dp = new int[len][2];
		dp[0][0] = 0;
		dp[0][1] = nums[0];
		dp[1][0] = nums[0];
		dp[1][1] = nums[1];

		for (int i = 2; i < len; i++) {
			dp[i][1] = Math.max(dp[i - 2][1], dp[i - 1][0]) + nums[i];
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
		}
		return Math.max(dp[len-1][0], dp[len-1][1]);
	}
}