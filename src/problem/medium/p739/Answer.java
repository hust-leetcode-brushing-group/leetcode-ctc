package problem.medium.p739;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class Answer {
    public static void main(String[] args) {
        int[] temperatures = {34, 80, 80, 34, 34, 80, 80, 80, 80, 34};
        System.out.println(Arrays.toString(new Solution_1().dailyTemperatures(temperatures)));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/11
 * 执行用时 :16 ms, 在所有 Java 提交中击败了87.02% 的用户
 * 内存消耗 :47.8 MB, 在所有 Java 提交中击败了6.45%的用户
 *
 * 又是看题解的一天。官解暴力法：
 * https://leetcode-cn.com/problems/daily-temperatures/solution/mei-ri-wen-du-by-leetcode-solution/
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        // next[i] 表示温度 i 第一次出现的时间
        int[] next = new int[101];
        // 从后往前遍历，同时更新 next
        for (int i = T.length - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = T[i] + 1; j <= 100; j++) {
                if (next[j] > i && next[j] < min) {
                    min = next[j];
                }
            }
            result[i] = min == Integer.MAX_VALUE ? 0 : min - i;
            next[T[i]] = i;
        }
        return result;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/15
 * 执行用时 :16 ms, 在所有 Java 提交中击败了81.24% 的用户
 * 内存消耗 :47.6 MB, 在所有 Java 提交中击败了6.45%的用户
 * 【单调栈】，专门解决【Next Greater Number】问题。感谢labuladong大佬的讲解
 */
class Solution_1 {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            // 此时栈顶即 i 之后的第一个比它高的元素的下标
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}