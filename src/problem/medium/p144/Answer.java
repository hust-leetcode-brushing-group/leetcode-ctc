package problem.medium.p144;

import common.TreeNode;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
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
 * 执行用时：1 ms, 在所有 Java 提交中击败了46.61% 的用户
 * 内存消耗：37.7 MB, 在所有 Java 提交中击败了6.38% 的用户
 * 参考：
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/miao-sha-quan-chang-ba-hou-lang-by-sonp/
 * 非递归的三种遍历方式的统一写法
 * 后序：p145 中序：p94
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> callStack = new LinkedList<>();
        if (root != null) callStack.push(root);
        while (!callStack.isEmpty()) {
            TreeNode cur = callStack.pop();
            if (cur != null) {
                if (cur.right != null) callStack.push(cur.right);
                if (cur.left != null) callStack.push(cur.left);
                callStack.push(cur);
                callStack.push(null);
            } else {
                result.add(callStack.pop().val);
            }
        }
        return result;
    }
}