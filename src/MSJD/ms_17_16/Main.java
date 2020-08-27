package MSJD.ms_17_16;

/**
 * 面试题 17.16. 按摩师
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1,3};
        System.out.println(new Solution().massage(nums));
    }
}

class Solution {
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1)
            return nums[0];

        int dp[] = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Integer.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Integer.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}