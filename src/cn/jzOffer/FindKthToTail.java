package cn.jzOffer;

import cn.jzOffer.help.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head, int k) {
        if(k <= 0) {
            return null;
        }
        //双指针
        ListNode back = head;
        ListNode front = head;
        for(int i = 0;i < k;i++) {
            if(front == null) {
                return null;
            }
            front = front.next;
        }
        while(front != null) {
            back = back.next;
            front = front.next;
        }

        return back;
    }
}
