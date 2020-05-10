package problem.medium.p863;

import common.TreeNode;

import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
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
 *
 * @author caoPhoenix
 * @date 2019/10/14
 * time 69.61% _
 *
 * 添加子节点对父节点的对应关系，然后广度优先搜索
 * 搜索过程中，设置一个special node，其val=-1，每将其插入队列一次，表示走了一个距离。
 */
class Solution {

    HashMap<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        tas(root);
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        HashSet<TreeNode> hs = new HashSet<TreeNode>();
        queue.add(target);
        TreeNode sp = new TreeNode(-1);
        queue.add(sp);
        hs.add(target);
        int step = 0;
        List<Integer> l = new ArrayList<Integer>();
        while (!queue.isEmpty() && step < K) {
            TreeNode node = queue.remove();
            if (node.val == -1) {
                step++;
                queue.add(sp);
                continue;
            }
            if (node.left != null && !hs.contains(node.left)) {
                hs.add(node.left);
                queue.add(node.left);
            }
            if (node.right != null && !hs.contains(node.right)) {
                hs.add(node.right);
                queue.add(node.right);
            }
            if (parent.get(node) != null && !hs.contains(parent.get(node))) {
                hs.add(parent.get(node));
                queue.add(parent.get(node));
            }
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.val != -1) {
                l.add(node.val);
            }
        }
        return l;

    }

    void tas(TreeNode node) {
        if (node.left != null) {
            parent.put(node.left, node);
            tas(node.left);
        }

        if (node.right != null) {
            parent.put(node.right, node);
            tas(node.right);
        }
    }
}

