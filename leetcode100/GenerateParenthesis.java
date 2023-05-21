package leetcode100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    StringBuffer path = new StringBuffer("(");
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }
        int left = n-1;
        int right = n;
        back(left,right);
        return result;
    }

    private void back(int left, int right) {
        if (left == 0 &&  right == 0) {
            result.add(path.toString());
            return;
        }
        if (left > 0) {
            path.append("(");
            back(--left,right);
            left++;
            path.deleteCharAt(path.length()-1);
        }
        if (right >0 && right >left) {
            path.append(")");
            back(left,--right);
            right++;
            path.deleteCharAt(path.length()-1);
        }
    }
}
