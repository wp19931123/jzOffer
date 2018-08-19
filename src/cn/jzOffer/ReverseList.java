package cn.jzOffer;

import cn.jzOffer.help.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        head.next = n1;
        n1.next = n2;

        ListNode.print(new ReverseList().ReverseList2(head));
    }

    //递归
    public ListNode ReverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        cur.next = null;
        ListNode newHead = ReverseList(next);
        next.next = cur;

        return newHead;
    }
    //非递归
    public ListNode ReverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }

        return newHead;
    }

}
