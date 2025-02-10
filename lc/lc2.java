package lc;
//链表两数相加
//class ListNode{
//    int val;
//    ListNode next;
//    ListNode(){};
//    ListNode(int val){this.val=val;};
//    ListNode(int val,ListNode next){this.val=val;this.next=next;};
//
//}
public class lc2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        int carry=0;
        while(l1 != null || l2 != null){
            int val1 = l1 == null ? 0:l1.val;
            int val2 = l2 == null ? 0:l2.val;
            int sum = (val1 + val2+carry) % 10;
            carry = (val1 + val2) / 10;
            tmp.val = sum;

            if(l1!=null){l1=l1.next;}
            if(l2!=null){l2=l2.next;}
            if(l1!=null || l2!=null){
                tmp.next = new ListNode();
                tmp = tmp.next;
            }

        }

        if(carry == 1){
            tmp.next = new ListNode(1);
        }
        return res;
    }

    public static void main(String[] args) {
        // 构造测试用例
        lc2 solution = new lc2();

        // 第一个链表 l1：代表数字 342（逆序存储）
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // 第二个链表 l2：代表数字 465（逆序存储）
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
//        l2.next.next.next = new ListNode(4);

        // 调用方法
        ListNode result = solution.addTwoNumbers(l1, l2);

        // 打印结果链表
        printList(result); // 结果应该是 7 -> 0 -> 8（表示数字 807）
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
