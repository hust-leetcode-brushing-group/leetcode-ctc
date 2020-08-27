package JZOffer.jzoffer_62;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题62. 圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().lastRemaining(3, 1));

    }
}

/**
 * 执行用时：1122 ms
 * 内存消耗：43.1 MB
 */
class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() != 1) {
            index = (index + m - 1) % list.size();
            //System.out.println(list.get(index));
            list.remove(index);
        }
        //System.out.println(Arrays.toString(list.toArray()));
        return list.get(0);
    }
}


/**
 * 执行用时：7 ms
 * 内存消耗：36.6 MB
 * 【约瑟夫环】数学解法
 */
class Solution_2 {
    public int lastRemaining(int n, int m) {
        int index = 0;
        for (int i = 2; i <= n; i++) {
            index = (index + m) % i;
        }
        return index;
    }
}