package problem.medium.p45;

public class Answer {
    public static void main(String[] args) {
        System.out.println(new Solution_2().jump(new int[]{10,9,8,7,6,5,4,3,2,1,1,0}));
    }
}

/**
 * O(n^2)动归，意料之中的超时
 */
class Solution {
    public int jump(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] <= dp[i - 1] && nums[j] >= i - j) {
                    dp[i] = Integer.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/04
 * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗 :41.8 MB, 在所有 Java 提交中击败了5.00%的用户
 *
 * 时间O(n)，空间O(1)，就两三个临时变量，内存消耗怎么只击败这么点。。。
 */
class Solution_2 {
    public int jump(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int count = 0;
        int next_end = nums[0];

        int i = 1;
        while (i < nums.length) {
            int end = next_end;
            count++;
            // 将能到达的最远距离都标记为count
            while (i <= end && i < nums.length) {
                // 遍历过程中，确定 步数加一 能到达的最远距离
                if (nums[i] + i > next_end) {
                    next_end = nums[i] + i;
                }
                i++;
            }
        }
        return count;
    }
}