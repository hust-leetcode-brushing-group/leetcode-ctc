package problem.medium.p152;

/**
 * 152. 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2019/07/10
 * time 17.47% .
 * mem . .
 *
 * DP
 */
class Solution {
    public int maxProduct(int[] nums){
        int[][] record = new int[nums.length][2];
        record[0][0] = nums[0];
        record[0][1] = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int t1 = record[i-1][0] * nums[i];
            int t2 = record[i-1][1] * nums[i];

            record[i][0] = Math.min(Math.min(t1,t2),nums[i]);
            record[i][1] = Math.max(Math.max(t1,t2),nums[i]);

            max = Integer.max(max,record[i][1]);
        }
        return max;
    }
}