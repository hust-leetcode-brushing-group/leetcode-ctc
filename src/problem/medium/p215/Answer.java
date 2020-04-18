package problem.medium.p215;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 */
public class Answer {
}


/**
 * @author caoPhoenix
 * @date 2019/07/10
 * time 27.14% _
 * mem _ _
 *
 * 快排中的 partition，理论上的最优解。实际上sort比我快太多了
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0,high = nums.length-1;
        int p = partition(nums, low, high)+1;
        while(k!=p)
        {
            if(k<p) //左边
            {
                high = p-2;
                p = partition(nums, low, high) + 1;
            }
            else if(k>p)    //右边
            {
                //k = k-p;
                low = p;
                p = partition(nums, low, high) +1;
            }
        }
        return nums[k-1];
    }

    public int partition(int[] nums, int low , int high)
    {
        int temp = nums[low];
        int i=low,j=high;
        while(i<j)
        {
            while(nums[j]<=temp && i<j) j--;
            nums[i] = nums[j];
            while(nums[i]>temp && i<j) i++;
            nums[j] = nums[i];
        }
        nums[i] = temp;
        return i;
    }
}