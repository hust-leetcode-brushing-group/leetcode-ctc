package problem.easy.p88;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Answer {
}

/**
 *
 * @Author:caoPhoenix
 * @Date:2019/07/09
 * @97.32%
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m-1;i>=0;i--)
        {
            nums1[n+i] = nums1[i];
        }
        // merge
        int i=0,j=0,k=0;
        while(i<m && j<n)
        {
            if(nums1[n+i]<nums2[j]) {nums1[k]=nums1[n+i];i++;k++;}
            else if(nums1[n+i]>nums2[j]) {nums1[k]=nums2[j];j++;k++;}
            else{nums1[k]=nums1[n+i];nums1[k+1] = nums2[j];i++;j++;k+=2;}
        }
        if(i==m)
        {
            for(;j<n;j++)
            {
                nums1[k]=nums2[j];
                k++;
            }
        }
    }
}