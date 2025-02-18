package lc;

import java.util.ArrayList;
import java.util.List;

// 子集
public class lc78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        int n = nums.length;
        for(int mask = 0;mask < (1<<n);mask++){
            tmp.clear();
            for(int i = 0;i < n;i++){
                if(((1 << i) & mask) != 0){
                    tmp.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }

    public static void main(String[] args) {
        lc78 solution = new lc78();

        // 测试用例 1: 空数组
        System.out.println("=== Test Case 1: Empty Array ===");
        int[] nums1 = {};
        List<List<Integer>> result1 = solution.subsets(nums1);
        System.out.println("Input: []");
        System.out.println("Output: " + result1); // 输出: [[]]

        // 测试用例 2: 单个元素
        System.out.println("\n=== Test Case 2: Single Element ===");
        int[] nums2 = {1};
        List<List<Integer>> result2 = solution.subsets(nums2);
        System.out.println("Input: [1]");
        System.out.println("Output: " + result2); // 输出: [[], [1]]

        // 测试用例 3: 两个元素
        System.out.println("\n=== Test Case 3: Two Elements ===");
        int[] nums3 = {1, 2};
        List<List<Integer>> result3 = solution.subsets(nums3);
        System.out.println("Input: [1, 2]");
        System.out.println("Output: " + result3); // 输出: [[], [1], [2], [1, 2]]

        // 测试用例 4: 三个元素
        System.out.println("\n=== Test Case 4: Three Elements ===");
        int[] nums4 = {1, 2, 3};
        List<List<Integer>> result4 = solution.subsets(nums4);
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output: " + result4);
        // 输出: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]

        // 测试用例 5: 重复元素
        System.out.println("\n=== Test Case 5: Repeated Elements ===");
        int[] nums5 = {1, 2, 2};
        List<List<Integer>> result5 = solution.subsets(nums5);
        System.out.println("Input: [1, 2, 2]");
        System.out.println("Output: " + result5);
        // 输出可能包含重复子集（如 [2, 2] 出现多次）

        // 测试用例 6: 边界条件
        System.out.println("\n=== Test Case 6: Large Input ===");
        int[] nums6 = {1, 2, 3, 4};
        List<List<Integer>> result6 = solution.subsets(nums6);
        System.out.println("Input: [1, 2, 3, 4]");
        System.out.println("Output: Total subsets = " + result6.size());
        System.out.println(result6);
        // 对于 4 个元素，输出包含 2^4 = 16 个子集
    }
}