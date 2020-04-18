package problem.easy.p125;

/**
 * 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome
 */
public class Answer {
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
        String s1 = s.replaceAll("[^a-zA-Z0-9]","");
        String s2 = new StringBuilder(s1).reverse().toString();
        return s1.equalsIgnoreCase(s2);
    }
}