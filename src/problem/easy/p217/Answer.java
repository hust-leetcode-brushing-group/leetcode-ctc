package problem.easy.p217;

import java.util.Arrays;

/**
 * 217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2019/07/10
 * time 97.03% _
 * mem _ _
 *
 * 排序
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        // 库函数排序可以通过， 97.03%
        // 我自己写的快排超时，性能差距有点大
        // quickSort(nums, 0, nums.length-1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }

    // 实际上，此快排函数在题目“912. 排序数组”中表现甚至优于 Arrays.sort()
    public void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int temp = nums[low];
        int l = low;
        int r = high;
        while (l < r) {
            while (nums[r] >= temp && l < r) r--;
            nums[l] = nums[r];
            while (nums[l] < temp && l < r) l++;
            nums[r] = nums[l];
        }
        nums[l] = temp;
        quickSort(nums, low, l - 1);
        quickSort(nums, r + 1, high);
    }
}