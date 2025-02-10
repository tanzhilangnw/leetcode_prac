package lc;

public class lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while(cur != null){
            for(int i = 0;i<k-1;i++){
                cur = cur.next;
                if(cur == null){
                    return dummy.next;
                }
            }
            ListNode tail = cur;
            ListNode curHead = pre.next;
            ListNode newHead = cur.next;
            ListNode[] rev =  reverse(curHead,tail);
            pre.next = rev[0];
            rev[1].next = newHead;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static ListNode[] reverse(ListNode head,ListNode tail){
        ListNode prev = new ListNode();
        prev.next = head;
        while(prev.next != tail){
            ListNode nex = head.next;
            prev.next = nex;
            tail.next = head;
            head = nex;
        }
        return new ListNode[]{tail,head};
    }

    public static void main(String[] args) {
        lc25 solution = new lc25();

        // 构造测试用例
        // 链表：1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 测试 k = 2
        System.out.println("Test case 1: k = 2");
        ListNode result1 = solution.reverseKGroup(head, 2);
        printList(result1); // 应输出：2 -> 1 -> 4 -> 3 -> 5

        // 构造新的链表
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 测试 k = 3
        System.out.println("Test case 2: k = 3");
        ListNode result2 = solution.reverseKGroup(head, 3);
        printList(result2); // 应输出：3 -> 2 -> 1 -> 4 -> 5

        // 测试链表长度不足 k 的情况
        head = new ListNode(1);
        head.next = new ListNode(2);

        System.out.println("Test case 3: k = 3 (length < k)");
        ListNode result3 = solution.reverseKGroup(head, 3);
        printList(result3); // 应输出：1 -> 2
    }

    // 打印链表的方法
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
