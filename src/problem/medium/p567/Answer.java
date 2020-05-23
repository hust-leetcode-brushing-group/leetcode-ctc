package problem.medium.p567;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class Answer {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(new Solution().checkInclusion(s1, s2));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/5/23
 * 执行用时 :29 ms, 在所有 Java 提交中击败了43.00% 的用户
 * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了12.50%的用户
 *
 * 【滑动窗口】
 * 就是 p438 的简化版
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : chs1) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;

        while (right < chs2.length) {
            char c = chs2[right++];
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) valid++;
            }
            while (right - left >= chs1.length) {
                if (valid == need.size()) return true;
                char d = chs2[left++];
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}