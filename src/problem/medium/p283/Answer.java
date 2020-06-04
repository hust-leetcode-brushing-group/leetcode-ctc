package problem.medium.p283;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/6/4
 * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗 :47.9 MB, 在所有 Java 提交中击败了11.76%的用户
 * 【脑筋急转弯】 不让用除法。。。。
 * 其实可以借助结果数组，以及一个变量来优化内存消耗。
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] mul_L = new int[nums.length];
        int[] mul_R = new int[nums.length];
        int[] result = new int[nums.length];

        // mul_L[i]: num[0] * ... * nums[i-1]
        mul_L[0] = 1;
        for (int i = 1; i < mul_L.length; i++) {
            mul_L[i] = mul_L[i - 1] * nums[i - 1];
        }
        // mul_R[i]: num[i+1] * ... * nums[length-1]
        mul_R[mul_R.length - 1] = 1;
        for (int i = mul_R.length - 2; i >= 0; i--) {
            mul_R[i] = mul_R[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = mul_L[i] * mul_R[i];
        }
        return result;
    }
}