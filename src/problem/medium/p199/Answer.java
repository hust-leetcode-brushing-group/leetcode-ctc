package problem.medium.p199;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
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
 * @date 2020/04/22
 * 执行用时 : 2 ms , 在所有 Java 提交中击败了 31.17% 的用户
 * 内存消耗 : 38.4 MB , 在所有 Java 提交中击败了 5.00% 的用户
 *
 * 层序遍历，记录每层最后一个节点
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        // 层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tmp = queue.remove();
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
                // 每层最后一个节点
                if (size == 1) result.add(tmp.val);
                size--;
            }
        }
        return result;
    }
}