package leetCode.letcode22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }
        if (left > right) {
            return;
        }
        // 如果左括号还剩余的话，可以拼接左括号
        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }
        // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        List<String> res = new Solution().generateParenthesis(10);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
