package problem.easy.p876;

/**
 * 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class Answer {
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 快慢指针
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        ListNode q = new ListNode(head.val);
        q.next = head.next;

        int count =0;
        while(p.next != null) {
            p = p.next;
            count++;
            if (count%2==0) {
                q = q.next;
            }
        }
        if (count%2==1) {
            q = q.next;
        }
        return q;
    }
}