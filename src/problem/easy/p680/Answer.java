package problem.easy.p680;

/**
 * 680. 验证回文字符串 Ⅱ
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class Answer {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(new Solution().validPalindrome(s));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/19
 * 执行用时 :7 ms, 在所有 Java 提交中击败了97.33% 的用户
 * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了6.67%的用户
 *
 * 思路很简单，两个索引从两端开始走，然后可以失败匹配一次
 */
class Solution {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int low = 0;
        int high = chars.length - 1;
        boolean deleted = false;
        while (low < high) {
            if (chars[low] != chars[high]) {
                if (!deleted) return isPalindrome(chars, low + 1, high) || isPalindrome(chars, low, high - 1);
                else return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public boolean isPalindrome(char[] chars, int low, int high) {
        while (low < high) {
            if (chars[low] != chars[high]) return false;
            low++;
            high--;
        }
        return true;
    }
}
