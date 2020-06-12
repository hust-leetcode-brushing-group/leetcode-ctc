package problem.medium.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class Answer {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(nums));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/12
 * 执行用时 :32 ms, 在所有 Java 提交中击败了28.36% 的用户
 * 内存消耗 :43.7 MB, 在所有 Java 提交中击败了98.74%的用户
 * 【双指针】，又是看题解的一天：
 * https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < nums.length; i++) {
            // 避免重复
            if (i == 0 || nums[i] != nums[i - 1]) {
                int k = nums.length - 1;
                for (int j = i + 1; j < nums.length; j++) {
                    // 避免重复
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                            k--;
                        }
                        // 当前的i找不到这样的j和k
                        if (j == k) break;
                        // 已经找到一组j和k
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        }
                    }
                }
            }
        }
        return result;
    }
}