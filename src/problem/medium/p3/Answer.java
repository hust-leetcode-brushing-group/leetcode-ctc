package problem.medium.p3;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Answer {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcad"));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/02
 * 执行用时 : 7 ms , 在所有 Java 提交中击败了 82.77% 的用户
 * 内存消耗 : 40.4 MB , 在所有 Java 提交中击败了 5.20% 的用户
 *
 * 【滑动窗口】 理论上是 O(n)。
 * 实际上应该把start前边的部分删除才对，但是删除的过程又需要O(n)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        int max = 0;
        int start = 0;

        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i]) && map.get(chs[i]) >= start) {
                start = map.get(chs[i]) + 1;
            }
            map.put(chs[i], i);
            max = max > (i - start + 1) ? max : (i - start + 1);
        }
        return max;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/02
 *
 * 执行用时 : 6 ms , 在所有 Java 提交中击败了 85.22% 的用户
 * 内存消耗 : 40 MB , 在所有 Java 提交中击败了 5.20% 的用户
 *
 * 暴力解法，理论上是 O(n^2)，但是很奇妙的是时间性能还挺快。
 */
class Solution_2 {
    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();

        int start = 0;
        int max = 0;
        for (int i = 0; i < chs.length; i++) {

            for (int j = start; j < i; j++) {
                if (chs[j] == chs[i])
                    start = j + 1;
            }
            max = max > (i - start + 1) ? max : (i - start + 1);
        }
        return max;
    }
}
