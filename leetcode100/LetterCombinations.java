package leetcode100;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;

public class LetterCombinations {
    static Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (StringUtils.isBlank(digits)) {
            return list;
        }
        for (int i = 0; i < phoneMap.get(digits.charAt(0)).length(); i++) {
            String result = phoneMap.get(digits.charAt(0)).charAt(i) + "";
            dsf(list,digits,result,1);
        }
        return list;
    }

    private void dsf(List<String> list, String digits, String result, int n) {
        if (n == digits.length()) {
            list.add(result);
            return ;
        }
        for (int i = 0; i < phoneMap.get(digits.charAt(n)).length(); i++) {
           result += phoneMap.get(digits.charAt(n)).charAt(i);
            dsf(list,digits,result,n+1);
            result = result.substring(0,result.length()-1);
        }
    }

}
