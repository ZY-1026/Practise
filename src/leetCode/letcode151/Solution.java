package leetCode.letcode151;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        s = s.trim(); // 去除首尾的空格
        Queue<String> queue = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char c = s.charAt(left);
            if ((stringBuilder.length() != 0 && (c == ' '))) {
                ((ArrayDeque<String>) queue).offerFirst(stringBuilder.toString());
                stringBuilder.setLength(0);
            } else if (c != ' ') {
                stringBuilder.append(c);
            }
            left++;
        }
        ((ArrayDeque<String>) queue).offerFirst(stringBuilder.toString());
        return String.join(" ", queue);
    }

    public String reverseWords1(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--; // 搜索第一个空格
            res.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间的空格
            j = i;
        }
        return res.toString().trim();
    }

    public String reverseWords2(String s) {
        String[] strings = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")) continue;
            stringBuilder.append(strings[i] + " ");
        }
        return stringBuilder.toString().trim();
    }
}
