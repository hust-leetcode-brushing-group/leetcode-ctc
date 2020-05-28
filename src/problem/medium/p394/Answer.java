package problem.medium.p394;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 */
public class Answer {
    public static void main(String[] args) {
        String str = "3[a2[c]]";
        System.out.println(new Solution().decodeString(str));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/5/28
 * 执行用时 :7 ms, 在所有 Java 提交中击败了16.25% 的用户
 * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了7.69%的用户
 *
 * 【正则表达式】 正则表达式的事，怎么能叫偷懒呢
 */
class Solution {
    public String decodeString(String s) {
        String regex = "([0-9]+)(\\[[^\\d^\\[^\\]]+\\])";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String to = matcher.group();
            // System.out.println(to);
            int num = Integer.parseInt(matcher.group(1));
            String _chs = matcher.group(2);
            String chs = _chs.substring(1, _chs.length() - 1);
            StringBuilder replace = new StringBuilder();
            for (int i = 0; i < num; i++) {
                replace.append(chs);
            }
            s = s.replace(to, replace.toString());
            matcher = pattern.matcher(s);
        }
        return s;
    }
}

/**
 * TODO 【栈】【递归】
 */
class Solution_1 {
}