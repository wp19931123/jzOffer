package cn.jzOffer;

import cn.jzOffer.help.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(1);
        ListNode[] n = {n1, n2, n3, n4, n5, n6, n7};
        for (int i = 0; i < 6; i++) {
            n[i].next = n[i + 1];
        }
        ListNode.print(n1);
        System.out.println();
        ListNode newHead = new DeleteDuplication().deleteDuplication(n1);
        ListNode.print(newHead);
    }

    //非递归
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode newHead = new ListNode(0);
        newHead.next = pHead;
        ListNode pre = newHead;
        ListNode cur = pHead;
        ListNode next = null;
        while (cur != null && cur.next != null) {
            next = cur.next;
            if (cur.val == next.val) {
                next = next.next;
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                pre.next = next;  //改变指向，相当于删除了重复的节点
                cur = next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return newHead.next;
    }

    //递归
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //当前节点是重复节点
        if (pHead.val == pHead.next.val) {
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        } else {
            //当前结点不是重复节点
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }


}
