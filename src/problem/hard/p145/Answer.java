package problem.hard.p145;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
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
 * 执行用时：1 ms, 在所有 Java 提交中击败了56.37% 的用户
 * 内存消耗：38 MB, 在所有 Java 提交中击败了5.13% 的用户
 * 参考：
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/miao-sha-quan-chang-ba-hou-lang-by-sonp/
 * 非递归的三种遍历方式的统一写法
 * 前序：p144 中序：p94
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> callStack = new LinkedList<>();
        if (root != null) callStack.push(root);
        while (!callStack.isEmpty()) {
            TreeNode cur = callStack.pop();
            if (cur != null) {
                callStack.push(cur);
                callStack.push(null); //标识已访问过还未处理
                if (cur.right != null) callStack.push(cur.right);
                if (cur.left != null) callStack.push(cur.left);
            } else {
                result.add(callStack.pop().val);
            }
        }
        return result;
    }
}