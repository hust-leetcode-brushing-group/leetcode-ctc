package problem.medium.p820;

import java.util.Arrays;

/**
 * 820. 单词的压缩编码
 * https://leetcode-cn.com/problems/short-encoding-of-words/
 */
public class Answer {
    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        System.out.println(new Solution().minimumLengthEncoding(words));
    }

}

/**
 * 按长度倒序拼接
 */
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        StringBuilder sb = new StringBuilder(words[0] + "#");
        StringBuilder temp = new StringBuilder();
        for (int i = 1; i < words.length; i++) {
            temp.setLength(0);
            temp.append(words[i]);
            temp.append("#");
            if (sb.indexOf(temp.toString()) < 0) {
                sb.append(temp);
            }
        }
        return sb.length();
    }
}

// TODO: Trie 前缀树
class Solution_2 {
    public int minimumLengthEncoding(String[] words) {

        return 0;
    }
}