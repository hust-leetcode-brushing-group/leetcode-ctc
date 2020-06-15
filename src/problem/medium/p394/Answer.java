package problem.medium.p394;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 */
public class Answer {
    public static void main(String[] args) {
        String str = "3[a]2[bc]";
        System.out.println(new Solution_1().decodeString(str));
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
 * @author caoPhoenix
 * @date 2020/5/28
 * 执行用时 :4 ms, 在所有 Java 提交中击败了33.05% 的用户
 * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了7.69%的用户
 * 【栈】速度快些了
 * 一个数字栈，一个字符栈，遇见 '[' 时把数字压栈，遇见 ']' 时开始进行处理
 */
class Solution_1 {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> charStack = new ArrayDeque<>();

        CharNode strHead = new CharNode('0');

        char[] chs = s.toCharArray();
        int num = 0;
        for (int i = 0; i < chs.length; i++) {
            if (Character.isDigit(chs[i])) {
                num = num * 10 + chs[i] - '0';
            } else if (chs[i] == '[') {
                charStack.push(chs[i]);
                numStack.push(num);
                num = 0;
            } else if (chs[i] == ']') {
                //开始处理
                char pop;
                while ((pop = charStack.pop()) != '[') {
                    // 头插链表以保持字母顺序
                    //System.out.println(pop);
                    CharNode temp = new CharNode(pop);
                    temp.next = strHead.next;
                    strHead.next = temp;
                }
                int multi = numStack.pop();
                //System.out.println(multi);
                // 将此段 [ ] 中的字符重复 multi 次再次插入栈中
                for (int j = 0; j < multi; j++) {
                    CharNode p = strHead.next;
                    while (p != null) {
                        charStack.push(p.c);
                        p = p.next;
                    }
                }
                strHead.next = null;
            } else {
                charStack.push(chs[i]);
            }
        }

        // 最后 charStack 中的所有字符即结果
        StringBuilder sb = new StringBuilder();
        for (Character character : charStack) {
            sb.append(character);
        }
        // 双端队列作为栈使用时，栈顶在队首，所以和遍历顺序是反的
        return sb.reverse().toString();
    }

    class CharNode {
        char c;
        CharNode next;

        public CharNode(char c) {
            this.c = c;
        }
    }
}


/**
 * TODO【递归】
 */