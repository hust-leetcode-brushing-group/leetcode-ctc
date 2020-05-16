package problem.hard.p25;

import common.ListNode;

/**
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class Answer {
}

/**
 * @author caoPhoenix
 * @date 2020/05/16
 * 执行用时 :1 ms, 在所有 Java 提交中击败了57.31% 的用户
 * 内存消耗 :40 MB, 在所有 Java 提交中击败了7.32%的用户
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p = root;
        ListNode q = head;
        int length = listLength(head);
        int time = length / k;

        for (int i = 0; i < time; i++) {
            int count = 0;
            ListNode tail = q;
            ListNode t;
            while (count != k) {
                t = q.next;
                q.next = p.next;
                p.next = q;
                q = t;
                count++;
            }
            p = tail;
        }
        // 倒插几次之后剩下的直接拼
        p.next = q;
        return root.next;
    }

    int listLength(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }
}