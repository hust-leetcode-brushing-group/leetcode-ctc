package problem.medium.p98;

import common.TreeNode;

public class Answer {
}

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */

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
 * @date 2020/05/05
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了5.80%的用户
 *
 * 中等题的难度浮动还挺大，这题感觉并不难。
 * 递归判断，每次传入当前节点的取值范围
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // 本来传 Integer.MIN_VALUE 和 Integer.MAX_VALUE 的，被用例 [2147483647] 拦住了
        return isValidNode(root, null, null);
    }

    public boolean isValidNode(TreeNode node, Integer min, Integer max) {
        if (null == node) return true;

        if ((null != min && node.val <= min)
                || (null != max && node.val >= max)) return false;

        return isValidNode(node.left, min, node.val) && isValidNode(node.right, node.val, max);
    }
}
