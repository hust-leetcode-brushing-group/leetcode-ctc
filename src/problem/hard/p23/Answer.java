package problem.hard.p23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class Answer {
}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 小顶堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null)
                queue.add(node);
        }
        if (queue.isEmpty()) return null;

        ListNode head = new ListNode(-1);
        ListNode p = head;
        do {
            ListNode q = queue.remove();
            p.next = q;
            p = p.next;
            if (q.next != null)
                queue.add(q.next);
        } while (!queue.isEmpty());
        return head.next;
    }
}