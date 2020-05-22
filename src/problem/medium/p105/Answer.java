package problem.medium.p105;

import common.TreeNode;

public class Answer {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        new Solution().buildTree(preorder, inorder);
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
 * @date 2020/05/22
 * 执行用时 :5 ms, 在所有 Java 提交中击败了43.28% 的用户
 * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了63.33%的用户
 *
 * 二叉树基本，递归解法
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 铭记非空判断
        if ((preorder == null || preorder.length == 0)
                && (inorder == null || inorder.length == 0))
            return null;

        TreeNode root = new TreeNode(0);
        recursive(root, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    public void recursive(TreeNode root, int[] pre, int pre_s, int pre_e, int[] in, int in_s, int in_e) {
        // 先序的第一个即根
        int now_root = pre[pre_s];
        root.val = now_root;
        // 在中序中找到根
        int i = in_s;
        for (; i < in_e; i++) {
            if (in[i] == now_root) break;
        }
        // 中序根左边即左子树，中序根右边即右子树
        int left = i - in_s;
        int right = in_e - i;
        //System.out.println("left:" + left + ", right:" + right);
        // 子树长度为 0 表示没有对应的子树
        if (left != 0) {
            root.left = new TreeNode(0);
            recursive(root.left, pre, pre_s + 1, pre_s + left, in, in_s, i - 1);
        }
        if (right != 0) {
            root.right = new TreeNode(0);
            recursive(root.right, pre, pre_e - right + 1, pre_e, in, i + 1, in_e);
        }
    }
}

// TODO 迭代
