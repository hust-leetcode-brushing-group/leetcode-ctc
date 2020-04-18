package problem.easy.p155;

import java.util.Arrays;

/**
 * 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack
 */
public class Answer {
}


/**
 * 解法一：
 * @Author:caoPhoenix
 * @Date:2019/07/10
 * @86.41%
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