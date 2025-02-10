package lc;
//删除链表倒数第N个结点
public class lc19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = head;

        for(int i =0;i<n;i++){
            tmp = tmp.next;
        }
        ListNode prev = dummy;
        while(tmp!=null){
            prev=prev.next;
            tmp=tmp.next;
        }
        prev.next = prev.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        removeNthFromEnd(head,2);
        printList(head);
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}
