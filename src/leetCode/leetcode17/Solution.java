package leetCode.leetcode17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private String letterMap[] = {
            " ", //
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    // s中保存的是digits[0....index-1]翻译得到的一个字母字符串
    private void findCombination(String digits, int index, String s, ArrayList<String> res) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++)
            findCombination(digits, index + 1, s + letters.charAt(i), res);
        return;
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits.equals(""))
            return res;

        findCombination(digits, 0, "", res);
        return res;
    }
}
