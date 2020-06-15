package problem.easy.p496;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/6/15
 * 执行用时 :6 ms, 在所有 Java 提交中击败了44.16% 的用户
 * 内存消耗 :40 MB, 在所有 Java 提交中击败了9.09%的用户
 * 【单调栈】
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}