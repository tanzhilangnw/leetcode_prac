package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//电话号码的字母组合
public class lc17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits.length() == 0){
            return res;
        }
        HashMap<Character,String> phoneMap = new HashMap<>();
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");
        backtrace(res,phoneMap,digits,0,new StringBuffer());
        return res;
    }

    public static void backtrace(List<String>res,HashMap<Character,String> phoneMap,String digits,int index,StringBuffer tmp){
        if(index == digits.length()){
            res.add(tmp.toString());
        }
        else{
            char ch = digits.charAt(index);
            String str = phoneMap.get(ch);
            int len = str.length();
            for(int i=0;i<len;i++){
                tmp.append(str.charAt(i));
                backtrace(res,phoneMap,digits,index+1,tmp);
                tmp.deleteCharAt(tmp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        lc17 solution = new lc17();

        // 测试用例 1：输入为空字符串
        String digits1 = "";
        List<String> result1 = solution.letterCombinations(digits1);
        System.out.println("输入: \"" + digits1 + "\" 输出: " + result1);

        // 测试用例 2：输入为单个数字
        String digits2 = "2";
        List<String> result2 = solution.letterCombinations(digits2);
        System.out.println("输入: \"" + digits2 + "\" 输出: " + result2);

        // 测试用例 3：输入为多个数字
        String digits3 = "23";
        List<String> result3 = solution.letterCombinations(digits3);
        System.out.println("输入: \"" + digits3 + "\" 输出: " + result3);

        // 测试用例 4：输入为另一个组合
        String digits4 = "456";
        List<String> result4 = solution.letterCombinations(digits4);
        System.out.println("输入: \"" + digits4 + "\" 输出: " + result4);
    }

}
