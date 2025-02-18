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

    //岛屿数量
    public static class lc200 {
        public static void dfs(char[][] grid,int r ,int c) {
            if(r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || grid[r][c] == '0') return;
            grid[r][c] = '0';
            dfs(grid,r+1,c);
            dfs(grid,r-1,c);
            dfs(grid,r,c+1);
            dfs(grid,r,c-1);
        }

        public static int numIslands(char[][] grid) {
            int res = 0;
            for(int i = 0;i < grid.length;i++) {
                for(int j =0;j < grid[0].length ;j++){
                    if(grid[i][j] == '1'){
                        res++;
                        dfs(grid,i,j);
                    }
                }
            }
            return res;
        }

        public static void main(String[] args) {
            // 测试用例 1：空网格
            char[][] grid1 = {};
            System.out.println("Test Case 1: " + lc200.numIslands(grid1)); // 期望输出：0

            // 测试用例 2：全是水的网格
            char[][] grid2 = {
                    {'0', '0', '0'},
                    {'0', '0', '0'},
                    {'0', '0', '0'}
            };
            System.out.println("Test Case 2: " + lc200.numIslands(grid2)); // 期望输出：0

            // 测试用例 3：全是陆地的网格（一个整体岛屿）
            char[][] grid3 = {
                    {'1', '1', '1'},
                    {'1', '1', '1'},
                    {'1', '1', '1'}
            };
            System.out.println("Test Case 3: " + lc200.numIslands(grid3)); // 期望输出：1

            // 测试用例 4：一个小岛屿
            char[][] grid4 = {
                    {'0', '0', '0'},
                    {'0', '1', '0'},
                    {'0', '0', '0'}
            };
            System.out.println("Test Case 4: " + lc200.numIslands(grid4)); // 期望输出：1

            // 测试用例 5：多个不相连的小岛屿
            char[][] grid5 = {
                    {'1', '0', '1'},
                    {'0', '0', '0'},
                    {'1', '0', '1'}
            };
            System.out.println("Test Case 5: " + lc200.numIslands(grid5)); // 期望输出：4

            // 测试用例 6：复杂岛屿分布
            char[][] grid6 = {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}
            };
            System.out.println("Test Case 6: " + lc200.numIslands(grid6)); // 期望输出：3
        }
    }
}
