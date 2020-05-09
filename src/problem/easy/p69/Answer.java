package problem.easy.p69;

import java.util.Random;

/**
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class Answer {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int x = r.nextInt(Integer.MAX_VALUE);
            System.out.println("sqrt(" + x + ") = " + (int) Math.sqrt(x));
            System.out.println("mySqrt(" + x + ") = " + new Solution().mySqrt(x));
        }
        //for (int x = 0; x < 10; x++) {
        //    System.out.println("sqrt(" + x + ") = " + (int) Math.sqrt(x));
        //    System.out.println("mySqrt(" + x + ") = " + new Solution_2().mySqrt(x));
        //}
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/09
 * 执行用时 :90 ms, 在所有 Java 提交中击败了5.00% 的用户
 * 内存消耗 :37.2 MB, 在所有 Java 提交中击败了5.55%的用户
 *
 * 乘法会溢出，所以改成除法，O(√n) 还是效率低。。。
 */
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int i = 1;
        while (i < x / i) i++;
        // 此时的 i 要么是结果，要么比结果大 1

        if (x / i < i) return i - 1;
        else return i;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/09
 * 执行用时 :2 ms, 在所有 Java 提交中击败了71.38% 的用户
 * 内存消耗 :36.7 MB, 在所有 Java 提交中击败了5.55%的用户
 *
 * 参考题解用二分优化一下，没想到 O(lnx) 比 O(√n) 快这么多
 */
class Solution_2 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 1;
        int r = x;  // int r = x / 2 + 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m == x / m || (m < x / m && (m + 1) > x / (m + 1))) return m;
            else if ( m < x / m ) l = m;    // m 比根小
            else r = m; // m 比根大
        }
        return 0;
    }
}