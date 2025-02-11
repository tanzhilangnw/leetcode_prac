package lc;
//K个一组翻转链表

public class lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;

        while (cur != null) {
            // 检查剩余节点是否足够 k 个
            for (int i = 0; i < k; i++) {
                cur = cur.next;
                if (cur == null) {
                    return dummy.next; // 剩余节点不足 k 个，直接返回
                }
            }

            // 保存下一段的起始节点
            ListNode nextNode = cur.next;

            // 反转当前 k 个节点
            ListNode[] res = reverse(pre.next, cur);
            ListNode chead = res[0]; // 反转后的头节点
            ListNode ctail = res[1]; // 反转后的尾节点

            // 连接反转部分和未反转部分
            pre.next = chead;
            ctail.next = nextNode;

            // 更新 pre 和 cur 指针
            pre = ctail;
            cur = ctail; // 或 cur = nextNode;
        }

        return dummy.next;
    }

    public static ListNode[] reverse(ListNode head,ListNode tail){
        ListNode prev = null;
        ListNode p = head;
        while(prev != tail){
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
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
//        ListNode[] res = reverse(head,head.next.next.next.next);
//        printList(res[0]);

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
