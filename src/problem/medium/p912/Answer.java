package problem.medium.p912;

import java.util.Arrays;

/**
 * 912. 排序数组
 * https://leetcode-cn.com/problems/sort-an-array/
 */
public class Answer {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        new Solution().sortArray(nums);
    }
}

/**
 * 快排
 */
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length == 1) return nums;
        else if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                int temp = nums[0];
                nums[0] = nums[1];
                nums[1] = temp;
            }
            return nums;
        }
        quick_sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    private void quick_sort(int[] nums, int begin, int end) {
        if (end <= begin) return;
        int temp = partition(nums, begin, end);
        quick_sort(nums, begin, temp - 1);
        quick_sort(nums, temp + 1, end);
    }

    private int partition(int[] arr, int begin, int end) {
        int key = arr[begin];
        int i = begin, j = end;

        while (j > i) {
            while (arr[j] >= key && j > i) j--;
            arr[i] = arr[j];
            while (arr[i] < key && j > i) i++;
            arr[j] = arr[i];
        }
        arr[i] = key;
        return i;
    }
}

/**
 * 快排
 * 哇，上面的代码怎么能写得这么难看
 * 意外找到了以前写的快排，看起来舒服多了
 */
class Solution_2 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

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

// TODO: 堆排序、归并排序
