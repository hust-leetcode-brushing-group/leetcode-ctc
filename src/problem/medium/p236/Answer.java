package problem.medium.p236;

import common.TreeNode;

import java.util.*;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Answer {
    public static void main(String[] args) {
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
 * @date 2020/05/10
 * 执行用时 :15 ms, 在所有 Java 提交中击败了16.41% 的用户
 * 内存消耗 :40.6 MB, 在所有 Java 提交中击败了5.71%的用户
 *
 * 参考了官方题解二。树问题中使用 map 存储父节点映射关系应该是常用技巧。
 * 官方题解一是使用递归，时间性能应该好很多
 * 本来打算新写一个带父节点指针的节点，然后重新建树，再获取到整个父亲路径的，现在看来确实不如直接用 map
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 用于存储父节点映射关系
        Map<Integer, TreeNode> fatherMap = new HashMap<>();
        // 存储寻找公共父节点过程中访问过的节点
        Set<TreeNode> visited = new HashSet<>();

        // 建立父亲映射关系
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                fatherMap.put(node.left.val, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                fatherMap.put(node.right.val, node);
                queue.add(node.right);
            }
        }

        // 将 p 的父亲全部加入 set
        TreeNode p_father = p;
        do {
            visited.add(p_father);
            p_father = fatherMap.get(p_father.val);
        } while (p_father != null);

        TreeNode q_father = q;
        do {
            if (visited.contains(q_father)) {
                return q_father;
            }
            q_father = fatherMap.get(q_father.val);
        } while (q_father != null);

        // 一般不会走到这里
        return root;
    }
}