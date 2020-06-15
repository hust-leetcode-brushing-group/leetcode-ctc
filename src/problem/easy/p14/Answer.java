package problem.easy.p14;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Answer {
    public static void main(String[] args) {
        String[] strs = {
                "a","a","b"
        };
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/6/15
 * 执行用时 :2 ms, 在所有 Java 提交中击败了33.84% 的用户
 * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了5.00%的用户
 * 直接暴力扫描即可
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String prefix = strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            if (i < strs[1].length() && strs[0].charAt(i) == strs[1].charAt(i)) ;
            else {
                prefix = strs[0].substring(0, i);
                break;
            }
        }
        if (prefix.length() == 0) return "";
        for (int i = 2; i < strs.length; i++) {
            for (int j = 0; j < prefix.length(); j++) {
                if (j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) ;
                else {
                    prefix = prefix.substring(0, j);
                    break;
                }
            }
        }
        return prefix;
    }
}