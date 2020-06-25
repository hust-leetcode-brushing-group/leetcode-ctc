package problem.medium.p16;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 */
public class Answer {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        System.out.println(new Solution().threeSumClosest(nums, 1));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/25
 * 执行用时：6 ms, 在所有 Java 提交中击败了86.03% 的用户
 * 内存消耗：39.5 MB, 在所有 Java 提交中击败了6.82% 的用户
 * 和 p15 一样的思路：排序+双指针将 O(n^3) 降为 O(n^2)
 * 加了个等于情况用时直接从 10ms -> 6ms 17.57% -> 86.03%
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int old_k = k, tmp = 0;
                while (j < k && (tmp = nums[i] + nums[j] + nums[k]) > target) {
                    k--;
                }
                if (j == k) { // 三数之和一直大于target
                    result = Math.abs(tmp - target) < Math.abs(result - target) ? tmp : result;
                    break; // j 也不用往后移了
                } else if (tmp == target) { // 三数之和等于target
                    return tmp;
                } else if (k == old_k) { // 三数之和一直小于target
                    result = Math.abs(tmp - target) < Math.abs(result - target) ? tmp : result;
                } else { // 当三数之和从大于target到小于target时，最接近的值就是这两个之一
                    if ((target - tmp) > ((nums[i] + nums[j] + nums[k + 1]) - target))
                        tmp = nums[i] + nums[j] + nums[k + 1];
                    if (Math.abs(tmp - target) < Math.abs(result - target))
                        result = tmp;
                }
            }
        }
        return result;
    }
}
