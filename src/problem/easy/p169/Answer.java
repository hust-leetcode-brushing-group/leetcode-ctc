package problem.easy.p169;


import java.util.Arrays;

/**
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2019/07/08
 * time 94.07% .
 * mem . .
 */
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        if(nums.length%2==1) {
            return nums[nums.length/2];
        }
        else
        {
            if(nums[nums.length/2-1]==nums[0]) return nums[nums.length/2-1];
            else return nums[nums.length/2];
        }
    }
}