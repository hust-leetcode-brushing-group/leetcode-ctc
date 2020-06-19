package problem.easy.p125;

/**
 * 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome
 */
public class Answer {
    public static void main(String[] args) {
        System.out.println(new Solution_1().isPalindrome("A man, a plan, a canal: Panama"));
    }
}

/**
 * @author caoPhoenix
 * @date 2019/07/08
 *
 * time 11.01%
 * mem
 *
 * 直接反转然后比较
 */
class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "");
        String s2 = new StringBuilder(s1).reverse().toString();
        return s1.equalsIgnoreCase(s2);
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/19
 * 执行用时：3 ms, 在所有 Java 提交中击败了93.04% 的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了7.14% 的用户
 * 把 Character.isDigit(c) || Character.isLetter(c) 换掉就快了不少
 */
class Solution_1 {
    public boolean isPalindrome(String s) {
        char[] chs = s.toLowerCase().toCharArray();
        int i = 0, j = chs.length - 1;
        while (i < j) {
            if (!((chs[i] >= '0' && chs[i] <= '9') || (chs[i] >= 'a' && chs[i] <= 'z'))) {
                i++;
                continue;
            }
            if (!((chs[j] >= '0' && chs[j] <= '9') || (chs[j] >= 'a' && chs[j] <= 'z'))) {
                j--;
                continue;
            }
            if (chs[i] != chs[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}