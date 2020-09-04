package leetCode.letcode917;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

public class Solution {
    public static String reverseOnlyLetters(String S) {
        List<Integer> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if ((S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')) {
                stack.push(S.charAt(i));
            } else {
                list.add(i);
            }
        }
        int index = 0;
        char[] chars = new char[stack.size()];
        while (!stack.isEmpty()) {
            chars[index] = stack.pop();
            index++;
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(chars));
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                char c = S.charAt(list.get(i));
                stringBuilder.insert(list.get(i).intValue(), c);
            }
        }
        return stringBuilder.toString();
    }
}
