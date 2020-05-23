package problem.medium.p438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class Answer {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(new Solution().findAnagrams(s, p));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/5/23
 * 执行用时 :35 ms, 在所有 Java 提交中击败了37.50% 的用户
 * 内存消耗 :40.7 MB, 在所有 Java 提交中击败了5.88%的用户
 *
 * 【滑动窗口】
 * 和 p76 同类型，再次剽窃labuladong大佬的算法。。。。
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : chp) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < chs.length) {
            char c = chs[right++];

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 关键之处：左边收缩条件
            while (right - left >= chp.length) {
                // 窗口长度的判断可以避免窗口中包含的字符比目标串多的情况
                if (valid == need.size()) {
                    result.add(left);
                }
                char d = chs[left++];
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return result;
    }
}