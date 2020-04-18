package problem.easy.p283;

/**
 * 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2019/07/10
 * time 94.60% _
 * mem _ _
 * <p>
 * 维护一个非0元素的index，遇见非0元素，则index++
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }
        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}