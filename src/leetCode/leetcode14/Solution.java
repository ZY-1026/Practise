package leetCode.leetcode14;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {

    // 方法一
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        // 对字符串进行排序
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.sort(strs);
        // 排序之后只需比较第一个和最后一个
        int first = strs[0].length();
        int last = strs[strs.length - 1].length();
        int num = Math.min(first, last);
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                stringBuilder.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    // 方法二
    // 寻找两个串的公共前缀
    public String helper(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        int index = 0;
        while (index < length && s1.charAt(index) == s2.charAt(index))
            index++;
        return s1.substring(0, index);
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = helper(prefix, strs[i]);
            if (prefix.length() == 0) break;
        }
        return prefix;
    }
}
