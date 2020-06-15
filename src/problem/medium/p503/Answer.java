package problem.medium.p503;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 503. 下一个更大元素 II
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/6/15
 * 执行用时 :9 ms, 在所有 Java 提交中击败了89.94% 的用户
 * 内存消耗 :41.7 MB, 在所有 Java 提交中击败了14.29%的用户
 * 【单调栈】 感谢labuladong大佬的模板
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }
            result[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % nums.length]);
        }
        return result;
    }
}