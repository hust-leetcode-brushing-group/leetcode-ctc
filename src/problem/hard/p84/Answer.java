package problem.hard.p84;

/**
 * 84. 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class Answer {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/5/30
 * 执行用时 :931 ms, 在所有 Java 提交中击败了21.14% 的用户
 * 内存消耗 :41.5 MB, 在所有 Java 提交中击败了23.91%的用户
 *
 * 暴力遍历
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            for (int j = i; j < heights.length; j++) {
                height = Integer.min(height, heights[j]);
                result = Integer.max(result, height * (j - i + 1));
            }
        }
        return result;
    }
}

/*
TODO 【单调栈】
 */