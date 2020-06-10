package problem.easy.p9;

/**
 * 9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class Answer {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/10
 * 执行用时 :10 ms, 在所有 Java 提交中击败了67.85% 的用户
 * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了5.14%的用户
 */
class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}