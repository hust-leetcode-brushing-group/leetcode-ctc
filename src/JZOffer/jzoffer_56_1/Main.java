package JZOffer.jzoffer_56_1;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class Main {
}

/**
 * @author caoPhoenix
 * @date 2020/04/28
 * 执行用时 : 3 ms , 在所有 Java 提交中击败了 37.01% 的用户
 * 内存消耗 : 41.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
 *
 * 还能这样做，抄答案。。。
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        // 看看异或结果第几位不为0，从0开始
        int index = 1;
        while (tmp % 2 == 0) {
            tmp /= 2;
            index++;
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // 第 index 位为 0 的是第 0 组
            if ((nums[i] >> index) % 2 == 0) {
                result[0] ^= nums[i];
            } else { // 第 index 位为 1 的是第 1 组
                result[1] ^= nums[i];
            }
        }
        return result;
    }
}