package MSJD.ms_10_03;

/**
 * 面试题 10.03. 搜索旋转数组
 * https://leetcode-cn.com/problems/search-rotate-array-lcci/
 */
public class Main {
}

class Solution {
    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[left] < arr[mid]){  // 左边升序

            } else if (arr[mid] < arr[right]){ // 右边升序

            }



        }


        return 0;
    }
}

