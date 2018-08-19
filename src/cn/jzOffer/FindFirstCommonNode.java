package cn.jzOffer;

import cn.jzOffer.help.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead1 == null) {
            return null;
        }
        //求长度
        int len1 = 0;
        int len2 = 0;
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != null) {
            len1++;
            node1 = node1.next;
        }
        while (node2 != null) {
            len2++;
            node2 = node2.next;
        }

        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                pHead1 = pHead1.next;
            }
        } else if (len2 > len1) {
            for (int i = 0; i < len2 - len1; i++) {
                pHead2 = pHead2.next;
            }
        }

        while (pHead1 != null && pHead1 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return null;
    }
}
