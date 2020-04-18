package problem.medium.p39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/01/07
 * time 100.00% _
 * mem 97.53% _
 *
 * 回溯
 */
class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> now = new ArrayList<Integer>();
        backTrack(now, candidates, 0, 0, target);
        return list;
    }

    public void backTrack(List<Integer> now, int[] candidates, int start, int sum, int target) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            list.add(new ArrayList<Integer>(now));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            now.add(candidates[i]);
            backTrack(now, candidates, i, sum + candidates[i], target);
            now.remove(now.size() - 1);
        }
    }
}