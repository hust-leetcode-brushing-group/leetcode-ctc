package problem.medium.p150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2019/08/08
 * time 83.20% .
 * mem . .
 *
 * 栈，此题虽为中等，但是挺简单的
 */
class Solution {
    public int evalRPN(String[] tokens) {
        //Stack<Integer> si = new Stack<Integer>();	//Stack继承自Vector，效率不高
        Deque<Integer> si = new ArrayDeque<>();	// 官方建议用Deque的实现类来使用栈
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                si.push(si.pop() + si.pop());
            }
            else if(s.equals("-")){
                int a = si.pop();
                int b = si.pop();
                si.push(b-a);
            }
            else if(s.equals("*")) {
                si.push(si.pop() * si.pop());
            }
            else if(s.equals("/")) {
                int a = si.pop();
                int b = si.pop();
                si.push(b/a);
            }
            else {
                si.push(Integer.parseInt(s));
            }
        }
        return si.peek();
    }
}