package problem.hard.p42;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Answer {
    public static void main(String[] args) {
        int[] height = new int[]{4, 2, 3};
        System.out.println(new Solution_1().trap(height));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/04/04
 * mem: 39.5 MB
 * time: 484 ms
 * 【暴力】 O(n^2)
 */
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int sum = 0;
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            max = height[i] > max ? height[i] : max;
        }
        for (int i = 1; i < height.length - 1; i++) {
            int h = 0; // 当前列水高
            for (h = max; h > height[i]; h--) {
                boolean left = false, right = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (height[j] >= h) {
                        left = true;
                        break;
                    }
                }
                for (int j = i + 1; j < height.length; j++) {
                    if (height[j] >= h) {
                        right = true;
                        break;
                    }
                }
                if (left && right) {
                    // System.out.println("第 " + i + " 列，水高：" + (h - height[i]));
                    break;
                }
            }
            sum += (h - height[i]);
        }
        return sum;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/15
 * 执行用时 :4 ms, 在所有 Java 提交中击败了31.48% 的用户
 * 内存消耗 :39.1 MB, 在所有 Java 提交中击败了12.86%的用户
 * 【单调栈】
 * 和大部分的题解里的单调栈不一样，仍然是【next greater number】的那种单调栈
 * 从左往右看：比当前柱子高的右边界，累积雨水，到最高则break；
 * 从右往左看：比当前柱子高的左边界，累积雨水，到最高则break；
 * 时间复杂度：O(4n)
 */
class Solution_1 {
    public int trap(int[] height) {
        int result = 0;
        int[] next_l = nextGreaterNumber(height);
        int[] next_r = preGreaterNumber(height);
        // 从左往右扫一遍
        for (int i = 0; i < next_l.length; i++) {
            if (next_l[i] == -1) break;
            int tmp_next = next_l[i];
            // 直到下一个边界之前，水位高度
            int tmp_h = height[i];
            while (i < tmp_next) {
                result += tmp_h - height[i];
                i++;
            }
            i--;
        }
        // 从右往左扫一遍
        for (int i = next_r.length - 1; i >= 0; i--) {
            if (next_r[i] == -1) break;
            int tmp_next = next_r[i];
            // 直到下一个边界之前，水位高度
            int tmp_h = height[i];
            while (i > tmp_next) {
                result += tmp_h - height[i];
                i--;
            }
            i++;
        }
        return result;
    }

    // 下一个更大或等于的数字的下标
    public int[] nextGreaterNumber(int[] height) {
        int[] result = new int[height.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = height.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    // 上一个更大的数字的下标
    public int[] preGreaterNumber(int[] height) {
        int[] result = new int[height.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}