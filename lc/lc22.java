package lc;

import java.util.ArrayList;
import java.util.List;

public class lc22 {
    public static List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        dfs("",left,right);
        return res;
    }

    public void dfs(String s,int left,int right){
        if(left == 0 && right == 0){
            res.add(s);
            return ;
        }

        if(left == right){
            dfs(s+"(",left-1,right);
        }
        else if(left < right){
            if(left > 0){
                dfs(s+"(",left-1,right);
            }
            dfs(s+")",left,right-1);
        }
    }

    public static void main(String[] args) {
        lc22 solution = new lc22();
        // 测试用例 1
        int n1 = 3;
        List<String> result1 = solution.generateParenthesis(n1);
        System.out.println("Test Case 1: n = " + n1);
        System.out.println("Generated Parentheses: " + result1);
        System.out.println("Expected: [\"((()))\", \"(()())\", \"(())()\", \"()(())\", \"()()()\"]\n");
        res.clear();

        // 测试用例 2
        int n2 = 1;
        List<String> result2 = solution.generateParenthesis(n2);
        System.out.println("Test Case 2: n = " + n2);
        System.out.println("Generated Parentheses: " + result2);
        System.out.println("Expected: [\"()\"]\n");
        res.clear();

        // 测试用例 3
        int n3 = 2;
        List<String> result3 = solution.generateParenthesis(n3);
        System.out.println("Test Case 3: n = " + n3);
        System.out.println("Generated Parentheses: " + result3);
        System.out.println("Expected: [\"(())\", \"()()\"]\n");
        res.clear();

        // 测试用例 4
        int n4 = 0;
        List<String> result4 = solution.generateParenthesis(n4);
        System.out.println("Test Case 4: n = " + n4);
        System.out.println("Generated Parentheses: " + result4);
        System.out.println("Expected: []\n");
        res.clear();

    }
}
