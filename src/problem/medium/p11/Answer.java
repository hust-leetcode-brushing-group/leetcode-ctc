package problem.medium.p11;

/**
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Answer {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution_2().maxArea(height));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/04/18
 * time . 714 ms
 * mem . 40.4 MB
 *
 * 暴力遍历
 */
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Integer.max(max, Integer.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/04/18
 * time . 4 ms
 * mem . 40.1 MB
 *
 * 双指针遍历
 */
class Solution_2 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int minBetweenLR = Integer.min(height[left], height[right]);
            max = Integer.max(max, minBetweenLR * (right - left));

            if (minBetweenLR == height[left]) left++;
            else right--;
        }
        return max;
    }
}