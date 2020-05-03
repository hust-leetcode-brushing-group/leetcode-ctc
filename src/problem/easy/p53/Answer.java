package problem.easy.p53;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray
 */
public class Answer {
    public static void main(String[] args) {
        new Solution_2().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}

/**
 * @author caoPhoenix
 * @date 2019/07/09
 * mem 99.96%
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int subArraySum = 0;
        int imin = 0, imax = 0;    //最后子序列的左右下标
        int subLeftIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            subArraySum += nums[i];
            if (subArraySum > sum) {
                sum = subArraySum;
                imin = subLeftIndex;
                imax = i;
            }
            if (subArraySum < 0) {
                subArraySum = 0;
                subLeftIndex = i + 1;
            }
        }
        return sum;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/03
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了95.72% 的用户
 * 内存消耗 :40 MB, 在所有 Java 提交中击败了35.95%的用户
 *
 * 之前写的 Solution 已经完全忘了，重写的时候怎么都想不出来。。。
 * 总之还是类似于动归的思路，保留一个前面数组加起来的“增益”，只有其大于0时才保留。
 */
class Solution_2 {
    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) return 0;

        int max = nums[0];    // 最大和
        int max_end = 0;    // 最大和的结尾
        int increment = nums[0] > 0 ? nums[0] : 0;  // 前面数的增益,只需要大于0的

        for (int i = 0; i < nums.length; i++) {
            max = Integer.max((increment + nums[i]), max);
            increment = increment + nums[i] > 0 ? increment + nums[i] : 0;
            //System.out.print(increment + " ");
            //System.out.println(max);
        }
        return max;
    }
}