package problem.hard.p124;

import common.TreeNode;

public class Answer {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * @author caoPhoenix
 * @date 2020/6/21
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.55% 的用户
 * 内存消耗：42 MB, 在所有 Java 提交中击败了7.69% 的用户
 * 递归？ 挺意外的，“秒杀”一道困难题，执行用时也挺短
 */
class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode node) {
        if (node == null) return 0;
        int l = maxPath(node.left);
        int r = maxPath(node.right);

        int temp = Integer.max(node.val, Integer.max(l + node.val, r + node.val));

        max = Integer.max(max, Integer.max(temp, l + r + node.val));

        return temp;
    }
}