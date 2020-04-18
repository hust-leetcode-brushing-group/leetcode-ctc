package problem.medium.p445;

/**
 * 445. 两数相加 II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
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

/**
 * 反转链表
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) {
            return l2;
        } else if (l2.val == 0) {
            return l1;
        }
        ListNode l1_rev = reverse(l1);
        ListNode l2_rev = reverse(l2);
        ListNode result = new ListNode(-1);
        int carry = 0;

        while (l1_rev != null || l2_rev != null || carry != 0) {
            int sum = carry;
            sum += (l1_rev != null ? l1_rev.val : 0);
            sum += (l2_rev != null ? l2_rev.val : 0);
            carry = sum / 10;
            // System.out.println(l1_num + "+" + l2_num + "=" + sum + "--" + carry);
            ListNode node = new ListNode(sum % 10);
            node.next = result.next;
            result.next = node;
            l1_rev = l1_rev != null ? l1_rev.next : null;
            l2_rev = l2_rev != null ? l2_rev.next : null;
        }
        return result.next;
    }

    // 反转链表
    public ListNode reverse(ListNode num) {
        ListNode head = new ListNode(-1);
        ListNode p;

        while (num != null) {
            p = num;
            num = num.next;
            p.next = head.next;
            head.next = p;
        }
        return head.next;
    }
}


// TODO: 不反转链表，用栈
class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }
}