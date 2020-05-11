package problem.medium.p50;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 */
public class Answer {
    public static void main(String[] args) {
        new Solution().myPow(2.00000, -2147483648);
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/11
 * 执行用时 :1 ms, 在所有 Java 提交中击败了94.50% 的用户
 * 内存消耗 :37 MB, 在所有 Java 提交中击败了5.88%的用户
 *
 * 偷懒直接搜了个快速幂算法
 */
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        else if (n > 0) return qpow(x, n);
        else if (n != Integer.MIN_VALUE) return 1 / qpow(x, -n);
        else return 1 / (qpow(x, Integer.MAX_VALUE) * x);
    }

    // 经典快速幂算法，将 n 看做二进制数
    double qpow(double a, int n) {
        double ans = 1.0;
        while (n > 0) {
            if ((n & 1) == 1)        //如果n的当前末位为1
                ans *= a;  //ans乘上当前的a
            a *= a;        //a自乘
            n >>= 1;       //n往右移一位
        }
        return ans;
    }

    // 递归形式的快速幂
    double recursive_qpow(double a, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 1)
            return qpow(a, n - 1) * a;
        else {
            double temp = qpow(a, n / 2);
            return temp * temp;
        }
    }
}