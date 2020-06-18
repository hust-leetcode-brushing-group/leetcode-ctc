package problem.hard.p1028;

import common.TreeNode;

/**
 * 1028. 从先序遍历还原二叉树
 * https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
 */
public class Answer {
    public static void main(String[] args) {
        new Solution().recoverFromPreorder("1-401--349---90--88");
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
 * @date 2020/6/18
 * 执行用时 :3 ms, 在所有 Java 提交中击败了94.39% 的用户
 * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了25.00%的用户
 * 还是挺欣慰的：①独立写出困难题；②一次通过；③用时比较短。
 *
 * 思路：
 * 维护两个值：指针 p 指向最后一个 new 出来的节点，深度 d 表示 p 的左孩子应当具有的深度
 * 然后开始读字符串 S，"---xxx" 可以读出一个 depth 和 value
 * 然后判断 depth == d，如果相等：则 value 应当是 p 的左孩子，new 出来之后更新 p 和 d；
 *                    否则不相等，则使用函数 findNow 寻找 value 的父节点 node，找到之后将 value 作为其右孩子，更新 p 和 d；
 *                              value 之所以一定是 node 的右孩子：左孩子的情况一定会进入 depth 和 d 相等的情况
 * 循环上述过程。
 *
 * findNow(root, depth)：需要找的节点的深度是 depth - 1
 * 如果 node 的右孩子不为空，由于字符串为先序，表示 node 的左子树已经处理完毕，故从右分支找下去。
 */
class Solution {
    public TreeNode recoverFromPreorder(String S) {
        char[] chs = S.toCharArray();
        int index = 0;
        int value = 0;
        while (index < chs.length && chs[index] != '-') { // 计算根节点的值
            value = value * 10 + chs[index] - '0';
            index++;
        }
        TreeNode root = new TreeNode(value);
        TreeNode p = root;
        int d = 1;  // p的下一个节点的深度
        while (index < chs.length) {
            int depth = 0;
            while (chs[index] == '-') { // 计算接下来节点的深度
                depth++;
                index++;
            }
            value = 0;
            while (index < chs.length && chs[index] != '-') { // 计算接下来节点的值
                value = value * 10 + chs[index] - '0';
                index++;
            }
            if (depth == d) {
                p.left = new TreeNode(value);
                p = p.left;
                d++;
            } else {
                p = root;
                p = findNow(p, depth);
                p.right = new TreeNode(value);
                p = p.right;
                d = depth + 1;
            }
        }
        return root;
    }

    private TreeNode findNow(TreeNode node, int depth) {
        //System.out.println(node.val);
        int d = 0;
        while (d != depth - 1) {
            if (node.right != null) node = node.right;
            else node = node.left;
            d++;
        }
        return node;
    }
}