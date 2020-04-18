package problem.easy.p53;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray
 */
public class Answer {
}

/**
 * @Author:caoPhoenix
 * @Date:2019/07/09
 * @99.96%
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        int subArraySum = 0;
        int imin = 0,imax=0;    //最后子序列的左右下标
        int subLeftIndex = 0;
        for(int i=0;i<nums.length;i++)
        {
            subArraySum+=nums[i];
            if(subArraySum > sum){
                sum = subArraySum;
                imin = subLeftIndex;
                imax = i;
            }
            if(subArraySum < 0){
                subArraySum = 0;
                subLeftIndex = i+1;
            }
        }
        return sum;
    }
}