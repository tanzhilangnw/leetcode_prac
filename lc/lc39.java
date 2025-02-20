package lc;

import java.util.ArrayList;
import java.util.List;

public class lc39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(candidates,0,target,res,tmp);
        return res;
    }

    public static void dfs(int[] candidates,int index,int target,List<List<Integer>> res,List<Integer> tmp){
        if(index == candidates.length){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(tmp));
            return;
        }

        dfs(candidates,index+1,target,res,tmp);

        if(target - candidates[index] >= 0){
            tmp.add(candidates[index]);
            dfs(candidates,index,target-candidates[index],res,tmp);
            tmp.remove(tmp.size()-1);
        }

    }

    public static void main(String[] args) {
        lc39 solution = new lc39();

        // 测试用例 1：目标为 0，期望为空列表
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 0;
        List<List<Integer>> result1 = solution.combinationSum(candidates1, target1);
        System.out.println("输入: candidates = " + arrayToString(candidates1) + ", target = " + target1);
        System.out.println("输出: " + result1);

        // 测试用例 2：简单的一个数字组合
        int[] candidates2 = {2, 3, 6, 7};
        int target2 = 7;
        List<List<Integer>> result2 = solution.combinationSum(candidates2, target2);
        System.out.println("输入: candidates = " + arrayToString(candidates2) + ", target = " + target2);
        System.out.println("输出: " + result2);

        // 测试用例 3：有多个组合的情况
        int[] candidates3 = {2, 3, 5};
        int target3 = 8;
        List<List<Integer>> result3 = solution.combinationSum(candidates3, target3);
        System.out.println("输入: candidates = " + arrayToString(candidates3) + ", target = " + target3);
        System.out.println("输出: " + result3);

        // 测试用例 4：无解的情况
        int[] candidates4 = {3, 5, 7};
        int target4 = 2;
        List<List<Integer>> result4 = solution.combinationSum(candidates4, target4);
        System.out.println("输入: candidates = " + arrayToString(candidates4) + ", target = " + target4);
        System.out.println("输出: " + result4);
    }

    // 辅助方法：将数组转换为字符串形式
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
