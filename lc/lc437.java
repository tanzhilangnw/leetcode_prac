package lc;

public class lc437 {
    public static int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int res = 0;
        res = rootSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    public static int rootSum(TreeNode root,int targetSum){
        int ret = 0;
        if(root == null){
            return 0;
        }

        if(root.val == targetSum){
            return 1;
        }

        ret = rootSum(root.left, targetSum-root.val) + rootSum(root.right, targetSum-root.val);
        return ret;
    }


    public static void main(String[] args) {
        // 测试用例 1：空树
        TreeNode root1 = null;
        System.out.println("Test Case 1: " + lc437.pathSum(root1, 10)); // 期望输出：0

        // 测试用例 2：单节点树，值等于目标值
        TreeNode root2 = new TreeNode(5);
        System.out.println("Test Case 2: " + lc437.pathSum(root2, 5)); // 期望输出：1

        // 测试用例 3：单节点树，值不等于目标值
        TreeNode root3 = new TreeNode(3);
        System.out.println("Test Case 3: " + lc437.pathSum(root3, 5)); // 期望输出：0

        // 测试用例 4：二叉树，存在多条路径满足目标和
        TreeNode root4 = new TreeNode(10);
        root4.left = new TreeNode(5);
        root4.right = new TreeNode(-3);
        root4.left.left = new TreeNode(3);
        root4.left.right = new TreeNode(2);
        root4.right.right = new TreeNode(11);
        root4.left.left.left = new TreeNode(3);
        root4.left.left.right = new TreeNode(-2);
        root4.left.right.right = new TreeNode(1);
        System.out.println("Test Case 4: " + lc437.pathSum(root4, 8)); // 期望输出：3

        // 测试用例 5：二叉树，无路径满足目标和
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        System.out.println("Test Case 5: " + lc437.pathSum(root5, 10)); // 期望输出：0

        // 测试用例 6：二叉树，目标和为负数
        TreeNode root6 = new TreeNode(-2);
        root6.right = new TreeNode(-3);
        System.out.println("Test Case 6: " + lc437.pathSum(root6, -5)); // 期望输出：1
    }
}
