package problem.hard.p42;

/**
 * 42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Answer {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(height));
    }
}

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
