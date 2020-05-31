package problem.easy.p101;

import common.TreeNode;

import java.util.*;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class Answer {
    public static void main(String[] args) {
        System.out.println();
    }
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
 * @date 2020/5/31
 * 执行用时 :2 ms, 在所有 Java 提交中击败了9.72% 的用户
 * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了5.00%的用户
 * 【层序遍历】二叉树，并判断每层是否是回文串
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            nums.clear();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.remove();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    nums.add(node.left != null ? node.left.val : null);
                    nums.add(node.right != null ? node.right.val : null);
                }
                size--;
            }
            // 每层都是回文序列
            int l = 0, r = nums.size() - 1;
            while (l < r) {
                if (!Objects.equals(nums.get(l), nums.get(r))) return false;
                l++;
                r--;
            }
        }
        return true;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/5/31
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了17.50%的用户
 * 【先序遍历】，以左右相反的顺序同步先序遍历根节点的左子树和右子树，并判断是否相等
 */
class Solution_1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return DLR(root.left, root.right);
    }

    private boolean DLR(TreeNode l, TreeNode r) {
        if (l != null && r != null) {
            return l.val == r.val && DLR(l.left, r.left) && DLR(l.right, r.right);
        } else if (l == null && r == null) return true;
        else return false;
    }
}