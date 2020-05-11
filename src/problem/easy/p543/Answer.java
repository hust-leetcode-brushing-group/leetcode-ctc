package problem.easy.p543;

import common.TreeNode;

/**
 * 543. 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class Answer {
}

class MyNode {
    int depth;  // 当前节点的最大深度
    TreeNode longest;   // 当前节点的最深叶子

    public MyNode(int depth, TreeNode longest) {
        this.depth = depth;
        this.longest = longest;
    }

    public MyNode inc() {
        this.depth++;
        return this;
    }
}

/**
 * @author caoPhoenix
 * @date 2020/05/11
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了5.26%的用户
 *
 * 直接在官解的代码改动，可以记录距离最远的两个节点
 */
class Solution {
    int max;
    TreeNode l_longest;
    TreeNode r_longest;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        depth(root);
        System.out.println(l_longest.val);
        System.out.println(r_longest.val);
        return max - 1;
    }

    public MyNode depth(TreeNode node) {
        if (node == null) return new MyNode(0, node);
        if (node.left == null && node.right == null) return new MyNode(1, node);    // 叶子

        MyNode L = depth(node.left);
        MyNode R = depth(node.right);

        if (L.depth + R.depth + 1 > max) {
            l_longest = L.longest;
            r_longest = R.longest;
            max = L.depth + R.depth + 1;
        }
        return L.depth > R.depth ? L.inc() : R.inc();
    }
}