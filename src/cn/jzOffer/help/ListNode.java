package cn.jzOffer.help;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static void print(ListNode head) {
        while (head != null) {
            if(head.next == null) {
                System.out.print(head.val);
            }else{
                System.out.print(head.val + "->");
            }

            head = head.next;
        }
    }
}
