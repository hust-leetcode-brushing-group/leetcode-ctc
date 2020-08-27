package JZOffer.jzoffer_51;

import java.util.Arrays;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{7, 5, 6, 4};
        System.out.println(new Solution().reversePairs(a));
        //System.out.println(Arrays.toString(a));
    }

}

/**
 * @author caoPhoenix
 * @date 2020/8/27
 * 执行用时：36 ms, 在所有 Java 提交中击败了84.42% 的用户
 * 内存消耗：48.9 MB, 在所有 Java 提交中击败了73.38% 的用户
 * 【归并排序】中加一个步骤即可
 */
class Solution {

    int count;

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return count;
    }

    private void mergeSort(int[] nums, int low, int high, int[] temp) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid, temp);
        mergeSort(nums, mid + 1, high, temp);
        // 合并 [low, mid] 和 [mid + 1, high] 两个有序数组
        merge(nums, low, mid, mid + 1, high, temp);
    }

    private void merge(int[] nums, int ll, int lh, int rl, int rh, int[] temp) {
        int lpoint = ll, rpoint = rl;
        int index = ll;
        while (lpoint <= lh && rpoint <= rh) {
            if (nums[lpoint] <= nums[rpoint]) {
                temp[index++] = nums[lpoint++];
                count += (rpoint - rl);
            } else {
                temp[index++] = nums[rpoint++];
            }
        }
        while (lpoint <= lh) {
            temp[index++] = nums[lpoint++];
            count += (rpoint - rl);
        }
        while (rpoint <= rh) {
            temp[index++] = nums[rpoint++];
        }
        System.arraycopy(temp, ll, nums, ll, rh - ll + 1);
    }
}