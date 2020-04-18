package problem.medium.p1111;

import java.util.Arrays;

/**
 * 1111. 有效括号的嵌套深度
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 */
public class Answer {
    public static void main(String[] args) {
        String seq = "()(())()";
        System.out.println(Arrays.toString(new Solution().maxDepthAfterSplit(seq)));
    }
}


class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        char[] chs = seq.toCharArray();
        int[] answer = new int[chs.length];

        int depth = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                answer[i] = depth % 2;
                depth++;
            } else if (chs[i] == ')'){
                depth--;
                answer[i] = depth % 2;
            }
        }
        return answer;
    }
}