package problem.medium.p213;

/**
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/01/06
 * time 22.02% _
 * mem 90.70% _
 * <p>
 * DP
 */
class Solution {
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] dp0 = new int[len]; //从0开始的dp表
        dp0[0] = nums[0];
        dp0[1] = nums[0];

        int[] dp1 = new int[len]; //从1开始的dp表
        dp1[0] = 0;
        dp1[1] = nums[1];

        for (int i = 2; i < len; i++) {
            dp0[i] = Math.max(dp0[i - 2] + nums[i], dp0[i - 1]);
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }

        return Math.max(dp0[len - 2], dp1[len - 1]);
    }
}