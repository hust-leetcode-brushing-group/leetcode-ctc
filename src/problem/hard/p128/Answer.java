package problem.hard.p128;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/6/6
 * 执行用时 :6 ms, 在所有 Java 提交中击败了58.71% 的用户
 * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了8.33%的用户
 * 【Hash表】又是看题解才会写的一天
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (numbers.contains(num - 1)) continue;
            int count = 0;
            while (numbers.contains(num)) {
                count++;
                num++;
            }
            result = Integer.max(result, count);
        }
        return result;
    }
}