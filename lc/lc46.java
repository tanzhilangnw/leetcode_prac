package lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// 全排列
public class lc46 {
    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static void dfs(int[] nums,int start,ArrayList<Integer> list){
        if(start == nums.length){ // && list.indexOf(2) < list.indexOf(3)){ 变体: 保证 2 在 3 左边
            res.add(new ArrayList<>(list));
        }

        for(int i = start;i < nums.length;i++){
            Collections.swap(list,i,start);
            dfs(nums,start+1,list);
            Collections.swap(list,i,start);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            list.add(nums[i]);
        }
        res = new ArrayList<>();
        dfs(nums,0,list);
        return res;
    }

    public static void main(String[] args) {
        // 测试用例 1: 空数组
        System.out.println("=== Test Case 1: Empty Array ===");
        int[] nums1 = {};
        List<List<Integer>> result1 = lc46.permute(nums1);
        System.out.println("Input: []");
        System.out.println("Output: " + result1); // 输出: []

        // 测试用例 2: 单个元素
        System.out.println("\n=== Test Case 2: Single Element ===");
        int[] nums2 = {1};
        List<List<Integer>> result2 = lc46.permute(nums2);
        System.out.println("Input: [1]");
        System.out.println("Output: " + result2); // 输出: [[1]]

        // 测试用例 3: 两个元素
        System.out.println("\n=== Test Case 3: Two Elements ===");
        int[] nums3 = {1, 2};
        List<List<Integer>> result3 = lc46.permute(nums3);
        System.out.println("Input: [1, 2]");
        System.out.println("Output: " + result3); // 输出: [[1, 2], [2, 1]]

        // 测试用例 4: 三个元素
        System.out.println("\n=== Test Case 4: Three Elements ===");
        int[] nums4 = {1, 2, 3};
        List<List<Integer>> result4 = lc46.permute(nums4);
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output: " + result4); // 输出: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

        // 测试用例 5: 重复元素
        System.out.println("\n=== Test Case 5: Repeated Elements ===");
        int[] nums5 = {1, 1, 2};
        List<List<Integer>> result5 = lc46.permute(nums5);
        System.out.println("Input: [1, 1, 2]");
        System.out.println("Output: " + result5); // 输出可能包含重复排列

        // 测试用例 6: 边界条件
        System.out.println("\n=== Test Case 6: Large Input (4 Elements) ===");
        int[] nums6 = {1, 2, 3, 4};
        List<List<Integer>> result6 = lc46.permute(nums6);
        System.out.println("Input: [1, 2, 3, 4]");
        System.out.println("Output: Total permutations = " + result6.size());
        System.out.println(result6); // 输出包含 4! = 24 个排列
    }

}
