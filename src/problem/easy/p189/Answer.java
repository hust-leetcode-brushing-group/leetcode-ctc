package problem.easy.p189;

/**
 * 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array
 */
public class Answer {
}


/**
 * @author caophoenix
 * @date 2019/07/09
 * time 61.21% .
 * mem . .
 *
 */
class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int start = 0, count = 0;
        for(;count<nums.length;start++)
        {
            int current = start;
            int extra = nums[current];
            do
            {
                int next = (current+k)%nums.length;
                int temp = nums[next];
                nums[next] = extra;
                extra = temp;
                current = next;
                count++;
            }while(start!=current);
        }
    }
}