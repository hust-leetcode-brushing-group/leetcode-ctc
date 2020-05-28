package problem.medium.p560;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class Answer {
    public static void main(String[] args) {
    }
}


/**
 * @author caoPhoenix
 * @date 2020/05/15
 * 执行用时 :413 ms, 在所有 Java 提交中击败了7.09% 的用户
 * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了7.69%的用户
 *
 * O(n^2)暴力遍历，下面超内存的版本里，其实二维数组并没有必要
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        // sums 为 [i,j] 的和
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) result++;
            for (int j = i + 1; j < nums.length; j++) {
                if ((sum += nums[j]) == k) result++;
            }
        }
        return result;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/22
 * 执行用时 :578 ms, 在所有 Java 提交中击败了5.03% 的用户
 * 内存消耗 :42.1 MB, 在所有 Java 提交中击败了7.69%的用户
 *
 * 用上了【前缀和】的思想，虽然还是 O(n^2)，但是里面的检索是可以用哈希表优化的。
 * 需要注意的是，两层循环各自的起止条件
 */
class Solution_1 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        // pre[i] 为前 i 个数的和
        int[] pre = new int[nums.length + 1];
        pre[0] = 0;
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        // pre[i] - pre[j] = k ==> sum[j+1, i] = k
        // 在 i 前面寻找 pre[j] = pre[i] - k
        // pre 从 0 开始是因为还有 0 = pre[i] - k
        // j = i-1 ==> pre[i] - pre[i-1] = nums[i] = k
        for (int i = 1; i < pre.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pre[j] == pre[i] - k)
                    result++;
            }
        }
        return result;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/22
 * 执行用时 :28 ms, 在所有 Java 提交中击败了52.96% 的用户
 * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了11.54%的用户
 *
 * 【前缀和】使用 hash 表来优化“检索满足条件的 j 的个数”这个过程
 */
class Solution_2 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        // key 为前 i 个数的和，value 为出现次数
        Map<Integer, Integer> preMap = new HashMap<>();
        int pre = 0;
        preMap.put(pre, 1);
        // pre 为前 i 个数的和, 从 0 开始是因为还有 0 = pre - k
        // pre(i) - pre(j) = k
        // 即 pre(j) = pre(i) - k 的 j 的个数
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            result += preMap.getOrDefault(pre - k, 0);
            preMap.put(pre, preMap.getOrDefault(pre, 0) + 1);
        }
        return result;
    }
}

/**
 * 超出内存限制
 */
class Solution_x {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        // sums[i][j]为[i,j]的和
        int[][] sums = new int[nums.length][nums.length];
        // 对于每个 i，在 [i+1, len) 之间寻找 j 满足和为 k
        for (int i = 0; i < nums.length; i++) {
            if ((sums[i][i] = nums[i]) == k) result++;
            for (int j = i + 1; j < nums.length; j++) {
                if ((sums[i][j] = sums[i][j - 1] + nums[j]) == k) result++;
            }
        }
        return result;
    }
}