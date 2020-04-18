package problem.easy.p136;

/**
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2019/07/08
 * time 68.14%
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++) {
            result ^= nums[i];
        }
        return result;
    }
}