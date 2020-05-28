package problem.medium.p974;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 */
public class Answer {
    public static void main(String[] args) {
        int[] A = {5, 0, -2, -3, 1};
        int K = 5;
        System.out.println(new Solution().subarraysDivByK(A, K));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/5/27
 * 执行用时 :31 ms, 在所有 Java 提交中击败了25.28% 的用户
 * 内存消耗 :45.8 MB, 在所有 Java 提交中击败了100.00%的用户
 *
 * 【前缀和】终于独立做出来一次。
 * 由于此题的前缀和只有K种，所以可以用数组来优化哈希表，这样时间会大幅减少
 */
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int result = 0;
        // 前缀和
        Map<Integer, Integer> preMap = new HashMap<>();
        // 之所以先put 0，考虑到 pre[i] 满足条件的情况
        preMap.put(0, 1);
        int pre = 0;
        for (int i = 0; i < A.length; i++) {
            /*
            取模：Math.floorMod，符号总是和后者一直
            求余：%，符号总是和前者一致

            Math.floorMod(pre + A[i], K)
             */
            pre = (pre + A[i]) % K;
            pre = (pre + K) % K;

            int t = preMap.getOrDefault(pre, 0);
            //System.out.println("i:" + i + " pre:" + pre + " t:" + t);
            result += t;
            preMap.put(pre, t + 1);
            /*
            在 [0, i)的范围内找满足下列条件的j
            [j+1, i] ->
            ( pre[i] - pre[j] ) % K = 0
            pre[i] % K - pre[j] % K = 0
            pre[i] % K = pre[j] % K
             */
        }
        return result;
    }
}