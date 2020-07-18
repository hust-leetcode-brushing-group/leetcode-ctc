package problem.medium.p94;

import common.TreeNode;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
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
 * @date 2020/7/18
 * 执行用时：1 ms, 在所有 Java 提交中击败了48.96% 的用户
 * 内存消耗：37.8 MB, 在所有 Java 提交中击败了5.79% 的用户
 * 参考：
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/miao-sha-quan-chang-ba-hou-lang-by-sonp/
 * 非递归的三种遍历方式的统一写法
 * 前序：p144 后序：p145
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> callStack = new LinkedList<>();
        if (root != null) callStack.push(root);
        while (!callStack.isEmpty()) {
            TreeNode cur = callStack.pop();
            if (cur != null) {
                if (cur.right != null) callStack.push(cur.right);
                callStack.push(cur);
                callStack.push(null); //标识已访问过还未处理
                if (cur.left != null) callStack.push(cur.left);
            } else {
                result.add(callStack.pop().val);
            }
        }
        return result;
    }
}


class Solution_1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}