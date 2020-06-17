package problem.medium.p1014;

public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/6/17
 * 执行用时 :3 ms, 在所有 Java 提交中击败了96.24% 的用户
 * 内存消耗 :48.6 MB, 在所有 Java 提交中击败了100.00%的用户
 * 又是看题解的一天。。。。
 */
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int temp_max = A[0];
        int max = Integer.MIN_VALUE;
        /*
        s = A[x] + A[y] + x - y = (A[x] + x) + (A[y] - y)
        在 [0, y) 中找到最大的 (temp_max = A[x] + x)，而 temp_max 可以随着遍历 y 而维护
        同时在遍历过程中维护最大的 (max = temp_max + A[y] - y) 即可
         */
        for (int i = 1; i < A.length; i++) {
            if ((A[i - 1] + i - 1) > temp_max) temp_max = A[i - 1] + i - 1;
            if (A[i] - i + temp_max > max) max = A[i] - i + temp_max;
        }
        return max;
    }
}