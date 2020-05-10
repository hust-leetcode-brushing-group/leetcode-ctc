package problem.easy.p572;

import common.TreeNode;

/**
 * 572. 另一个树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class Answer {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.toString());
        System.out.println(sb.toString().contains(new StringBuilder()));
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
 * @date 2020/05/07
 * 执行用时 :22 ms, 在所有 Java 提交中击败了5.60% 的用户
 * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了40.00%的用户
 *
 * 面向测试用例编程~
 * 本来想着，前序遍历中序遍历能确定二叉树的结构，就遍历一次然后判断contain，然后错误测试用例告诉我：可能还需要后序。
 * 加了后序之后，错误测试用例告诉我：可能还需要中序以 t 开头或结尾。
 * 再改之后，错误测试用例告诉我：包含许多重复数的二叉树，还是能让你错。
 *
 * 看了看题解，发现只需要一种遍历方式，给叶子节点的子加上 null 标记就可以解决前面所有的问题
 * 然后错误测试用例：[12] [2] 再次打我脸。不过这确实是我考虑不周了。
 * 给数字加上"|"包裹起来之后终于通过了。
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder sb_pre = new StringBuilder();
        DLR(s, sb_pre);
        StringBuilder tb_pre = new StringBuilder();
        DLR(t, tb_pre);
        return sb_pre.toString().contains(tb_pre);
    }

    public void DLR(TreeNode node, StringBuilder sb) {
        if (null == node) {
            sb.append("*");
            return;
        }
        sb.append("|" + node.val + "|");
        DLR(node.left, sb);
        DLR(node.right, sb);
    }
}

/**
 * 初始的错误版本
 */
class Solution_ {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder sb_pre = new StringBuilder();
        DLR(s, sb_pre);
        StringBuilder tb_pre = new StringBuilder();
        DLR(t, tb_pre);

        StringBuilder sb_in = new StringBuilder();
        LDR(s, sb_in);
        StringBuilder tb_in = new StringBuilder();
        LDR(t, tb_in);

        StringBuilder sb_post = new StringBuilder();
        LRD(s, sb_post);
        StringBuilder tb_post = new StringBuilder();
        LRD(t, tb_post);

        String s_pre = sb_pre.toString();
        String t_pre = tb_pre.toString();
        String s_in = sb_in.toString();
        String t_in = tb_in.toString();
        String s_post = sb_post.toString();
        String t_post = tb_post.toString();
        return s_pre.contains(t_pre) && s_post.contains(t_post) &&
                (s_in.startsWith(t_in) || s_in.endsWith(t_in));
    }

    public void DLR(TreeNode node, StringBuilder sb) {
        if (null == node) return;
        sb.append(node.val);
        DLR(node.left, sb);
        DLR(node.right, sb);
    }

    public void LDR(TreeNode node, StringBuilder sb) {
        if (null == node) return;
        LDR(node.left, sb);
        sb.append(node.val);
        LDR(node.right, sb);
    }

    public void LRD(TreeNode node, StringBuilder sb) {
        if (null == node) return;
        LRD(node.left, sb);
        LRD(node.right, sb);
        sb.append(node.val);
    }
}