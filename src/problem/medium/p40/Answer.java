package problem.medium.p40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/01/07
 * time 78.63% _
 * mem 83.81% _
 *
 * 回溯
 */
class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> now = new ArrayList<Integer>();
        backTrack(now, candidates, 0, 0, target);
        return list;
    }

    public boolean backTrack(List<Integer> now, int[] candidates, int start, int sum, int target) {
        if (sum > target) {
            return false;
        } else if (sum == target) {
            list.add(new ArrayList<Integer>(now));
            return true;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            now.add(candidates[i]);
            boolean flag = backTrack(now, candidates, i + 1, sum + candidates[i], target);
            now.remove(now.size() - 1);
            // 剪枝：表明sum已经大于target，后面的可以不搜了
            if (!flag) {
                break;
            }
        }
        return true;
    }
}