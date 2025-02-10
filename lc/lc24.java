package lc;
//链表两两交换
public class lc24 {
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode prev = res;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            ListNode nex = cur.next;
            cur.next = cur.next.next;
            prev.next = nex;
            nex.next = cur;

            prev = cur;
            cur = cur.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        lc24 solution = new lc24();

        // 构造测试用例
        // 链表：1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // 调用方法
        ListNode result = solution.swapPairs(head);

        // 打印结果
        printList(result); // 应输出：2 -> 1 -> 4 -> 3
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
