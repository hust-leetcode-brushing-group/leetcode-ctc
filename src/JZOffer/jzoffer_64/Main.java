package JZOffer.jzoffer_64;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
public class Main {
    public static void main(String[] args) {
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/2
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了100.00%的用户
 *
 * 脑筋急转弯。&& 和 || 的短路性质
 */
class Solution {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}