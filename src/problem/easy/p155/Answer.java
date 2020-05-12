package problem.easy.p155;

import java.util.Arrays;

/**
 * 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack
 */
public class Answer {
}


/**
 * @author caoPhoenix
 * @date 2019/07/10
 * time 100ms 86.41%
 *
 * 更新：
 * @date 2020/05/12
 * 执行用时 :7 ms, 在所有 Java 提交中击败了85.70% 的用户
 * 内存消耗 :43.5 MB, 在所有 Java 提交中击败了10.84%的用户
 *
 * 之前的代码现在再看只战胜7.64%了。
 * 遂调把 capital 调成10倍，100000。
 * 顺便感叹下要是我现在写，肯定会用库里的栈，而不是自己实现一个栈
 */
class MinStack {
    private int[] data;
    private int capital;
    private int top;

    private int[] minHistory;
    private int mhcap;
    private int mhtop;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        capital = 10000;
        data = new int[capital];
        top = 0;

        mhcap = 10000;
        mhtop = 1;
        minHistory = new int[mhcap];
        minHistory[0] = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (top >= capital)    //考虑了扩容所以慢一点
        {
            capital *= 2;
            data = Arrays.copyOf(data, capital);
        }
        data[top++] = x;


        if (mhtop >= mhcap) {
            mhcap *= 2;
            minHistory = Arrays.copyOf(minHistory, mhcap);
        }
        if (x <= minHistory[mhtop - 1]) {
            minHistory[mhtop++] = x;
        }
    }

    public void pop() {
        if (top > 0) {
            if (data[top - 1] == minHistory[mhtop - 1]) {
                mhtop--;
            }
            top--;
        }
    }

    public int top() {
        return data[top - 1];
    }

    public int getMin() {
        return minHistory[mhtop - 1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */