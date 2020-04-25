package problem.medium.p46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Answer {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new Solution().permute(nums));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/04/25
 * 执行用时 : 2 ms , 在所有 Java 提交中击败了 80.28% 的用户
 * 内存消耗 : 39.7 MB , 在所有 Java 提交中击败了 7.32% 的用户
 * <p>
 * 思路：遍历数组，已经遍历了 n 个数字，有 n+1 个位置可以插入；
 * 第 n+1 个数字在每个可以插的位置插入，并保存。
 * 直接暴力循环，没想到耗时还不是很多
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> queue = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return queue;

        List<Integer> init = new LinkedList<>();
        init.add(nums[0]);
        queue.add(init);

        for (int i = 1; i < nums.length; i++) {
            int size = queue.size();
            while (size > 0) {
                List<Integer> tmp = queue.remove();
                for (int j = 0; j <= tmp.size(); j++) {
                    List<Integer> list = new LinkedList<>(tmp);
                    list.add(j, nums[i]);
                    queue.add(list);
                }
                size--;
            }
        }
        return queue;
    }
}