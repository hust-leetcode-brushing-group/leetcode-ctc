package problem.medium.p151;


/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class Answer {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("  hello world!  "));
    }
}


class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");

        StringBuilder sb = new StringBuilder(words[words.length - 1]);

        for (int i = words.length - 2; i >= 0; i--) {
            sb.append(" ");
            sb.append(words[i]);
        }
        return sb.toString();
    }
}