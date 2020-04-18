package problem.easy.p387;

/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class Answer {
}


/**
 * @author caoPhoenix
 *
 * 遍历一次，使用一个数组记录每个字母的次数
 * 再遍历一次，返回频率为1的字母
 */
class Solution {
    public int firstUniqChar(String s) {
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            a[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (a[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}