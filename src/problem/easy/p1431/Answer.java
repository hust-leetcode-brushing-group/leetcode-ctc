package problem.easy.p1431;

import java.util.ArrayList;
import java.util.List;

public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/6/1
 * 执行用时 :1 ms, 在所有 Java 提交中击败了99.84% 的用户
 * 内存消耗 :39.1 MB, 在所有 Java 提交中击败了100.00%的用户
 *
 * 送分题有那么多题解是我没想到的
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = findMax(candies);
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] >= max - extraCandies);
        }
        return result;
    }

    private int findMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max)
                max = num;
        }
        return max;
    }
}