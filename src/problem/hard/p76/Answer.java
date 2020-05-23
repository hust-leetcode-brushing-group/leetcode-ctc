package problem.hard.p76;

import java.util.*;

/**
 * 76. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class Answer {
    public static void main(String[] args) {
        String S = "a";
        String T = "abcv";
        System.out.println(new Solution().minWindow(S, T));
    }
}


/**
 * @author caoPhoenix
 * @date 2020/5/23
 * 执行用时 :18 ms, 在所有 Java 提交中击败了54.70% 的用户
 * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了13.33%的用户
 *
 * 【滑动窗口】
 * 本来写了个不考虑 t 中重复字符的，用 set 来存，结果被题目坑了
 * 然后就看了看 labuladong 大佬的题解：
 * https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-suan-fa-tong-yong-si-xiang-by-/
 */
class Solution {
    public String minWindow(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 把需要的字符加入 need map 中
        for (char c : cht) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;    // 滑动窗口的左右边界
        int valid = 0;      // window 中满足要求的字符的数量
        int start = 0, len = Integer.MAX_VALUE;

        // 滑动窗口 [left, right)
        while (right < chs.length) {
            // 窗口右端右移
            char c = chs[right++];

            // **1. 更新窗口
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // Integer 不应直接 ==，有缓存问题
                if (window.get(c).equals(need.get(c))) valid++;
            }

            // **2. 满足条件时收缩左窗口
            while (valid == need.size()) {
                // 满足条件时计算最小长度
                if (len > right - left) {
                    len = right - left;
                    start = left;
                }
                // 左端右移
                char d = chs[left++];

                // **3. 更新窗口
                if (window.containsKey(d)) {
                    // 如果 window 内 d 出现的次数刚好和 need 的次数相等，
                    // 由于次数需要减 1，故 valid 减 1
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 窗口右端移至最右侧时结束
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}