package lc;

public class lc141 {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            if(fast == slow){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        // 测试用例：非环形链表
        ListNode nonCyclicHead = new ListNode(1);
        nonCyclicHead.next = new ListNode(2);
        nonCyclicHead.next.next = new ListNode(3);
        nonCyclicHead.next.next.next = new ListNode(4);

        System.out.println("Test Case 1 (Non-Cyclic): " + hasCycle(nonCyclicHead)); // 预期输出：false

        // 测试用例：环形链表
        ListNode cyclicHead = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        cyclicHead.next = second;
        second.next = third;
        third.next = second; // 创建环：第三个节点指向第二个节点

        System.out.println("Test Case 2 (Cyclic): " + hasCycle(cyclicHead)); // 预期输出：true

        // 边界测试：空链表
        ListNode emptyHead = null;
        System.out.println("Test Case 3 (Empty List): " + hasCycle(emptyHead)); // 预期输出：false

        // 边界测试：单节点链表，无环
        ListNode singleNode = new ListNode(1);
        System.out.println("Test Case 4 (Single Node, No Cycle): " + hasCycle(singleNode)); // 预期输出：false

        // 边界测试：单节点链表，自环
        ListNode singleNodeCycle = new ListNode(1);
        singleNodeCycle.next = singleNodeCycle; // 自环
        System.out.println("Test Case 5 (Single Node, Self Cycle): " + hasCycle(singleNodeCycle)); // 预期输出：true
    }
}
