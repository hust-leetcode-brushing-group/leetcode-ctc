package problem.medium.p102;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Answer {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**
 * @author caoPhoenix
 * @date 2020/05/13
 * 执行用时 :2 ms, 在所有 Java 提交中击败了22.80% 的用户
 * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了5.71%的用户
 *
 * 最常规的队列层序遍历，看了下提交记录，如果用递归做好像会快不少
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            result.add(list);
        }
        return result;
    }
}