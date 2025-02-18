package lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class lc102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int cursize = queue.size();
            List<Integer> level = new ArrayList<Integer>();

            for(int i =0;i < cursize;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }

            }

            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        // 构造测试用的二叉树
        // 示例树：
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 调用 levelOrder 方法
        List<List<Integer>> result = lc102.levelOrder(root);

        // 打印结果
        System.out.println("层序遍历结果：");
        for (List<Integer> level : result) {
            System.out.println(level);
        }

//        // 测试空树的情况
//        TreeNode emptyRoot = null;
//        List<List<Integer>> emptyResult = lc102.levelOrder(emptyRoot);
//        System.out.println("空树层序遍历结果：");
//        System.out.println(emptyResult);
    }
}
