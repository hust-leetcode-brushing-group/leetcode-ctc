package problem.medium.p287;


public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/5/26
 * 执行用时 :3 ms, 在所有 Java 提交中击败了60.11% 的用户
 * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了6.67%的用户
 *
 * 【二分查找】的奇妙用法，参考liweiwei大佬的题解：
 * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
 */
class Solution {
    public int findDuplicate(int[] nums) {
        // 长度为 n + 1 的数组
        int n_plus = nums.length;
        // 数的范围为 [1, n]
        int l = 1, r = n_plus - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            int less = 0;
            for (int i = l; i < nums.length; i++) {
                if (nums[i] <= m) less++;
            }
            // 小于等于m的数如果多于m个，则重复数在[l,m]中，否则在(m,r]中
            if (less > m) r = m;
            else l = m;
        }
        return l;
    }
}