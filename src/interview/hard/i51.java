package interview.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class i51 {
    public static void main(String[] args) {
        new Solution().reversePairs(new int[]{1, 3, 2, 3, 1});
    }
}

/**
 * 抄答案
 */
class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    int merge(int[] arr, int start, int end) {
        if (start == end) return 0;
        int mid = start + (end - start) / 2;
        int count = merge(arr, start, mid) + merge(arr, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            count += arr[i] <= arr[j] ? j - (mid + 1) : 0;
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            count += j - (mid + 1);
            temp[k++] = arr[i++];
        }
        while (j <= end)
            temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, start, end - start + 1);
        return count;
    }
}

/* 归并模板
void merge(int[] arr, int start, int end) {
    if (start == end) return;
    int mid = (start + end) / 2;
    merge(arr, start, mid);
    merge(arr, mid + 1, end);

    int[] temp = new int[end - start + 1];
    int i = start, j = mid + 1, k = 0;
    while (i <= mid && j <= end)
        temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    while (i <= mid)
        temp[k++] = arr[i++];
    while (j <= end)
        temp[k++] = arr[j++];
    System.arraycopy(temp, 0, arr, start, end);
}
*/