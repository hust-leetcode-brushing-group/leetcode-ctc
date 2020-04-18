package problem.medium.p55;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class Answer {
}

// O(n^2) 1ms
class Solution {
    public boolean canJump(int[] nums) {
        boolean can = true;
        if (nums.length == 1)
            return can;
        jump:
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                // 每次遇到0，开始检索这个0是否可以跳过
                can = false;
                for (int k = i - 1; k >= 0; k--) {
                    if (nums[k] > i - k) {
                        can = true;
                        break;
                    }
                }
                // 循环结束都还是false的话，表示当前这个0跳不出去，直接结束
                if (!can) break jump;
            }
        }
        return can;
    }
}

// O(n) 1ms
class Solution_2 {
    public boolean canJump(int[] nums) {
        // 第一格需要跳的距离
        int d = nums.length - 1;
        for (int i = nums.length - 2; i >= 1; i--) {
            if (nums[i] >= d - i) {
                // 从第i格能调到目标位置，更新第一格需要跳的距离
                d = i;
            }
        }
        return nums[0] >= d;
    }
}