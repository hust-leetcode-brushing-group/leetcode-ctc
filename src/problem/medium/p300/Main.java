package problem.medium.p300;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/8/15
 * 执行用时：16 ms, 在所有 Java 提交中击败了24.27% 的用户
 * 内存消耗：37.7 MB, 在所有 Java 提交中击败了37.15% 的用户
 * 【动态规划】 O(n^2)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int[] dp = new int[nums.length]; // 以nums[i]结尾的递增序列的长度
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
            }
            res = Integer.max(res, dp[i]);
        }
        return res;
    }
}