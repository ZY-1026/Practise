package leetCode.letcode438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        /** 超出了时间限制
         List<Integer> list = new ArrayList<>();
         if (s == null || s.length() == 0) return list;
         int length = p.length();
         for (int i = 0; i < s.length(); i++) {
         if (i + length > s.length()) break;
         String p1 = p;
         String tmp = s.substring(i, i + length);
         char[] c = tmp.toCharArray();
         char[] tmp_p = p1.toCharArray();
         Arrays.sort(c);
         Arrays.sort(tmp_p);
         if (String.valueOf(c).equals(String.valueOf(tmp_p))) {
         list.add(i);
         }
         }
         return list;
         **/
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0) return list;
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        String tmpP = String.valueOf(pChars);
        int lastIndex = s.length() - p.length();
        if (lastIndex < 0) return list;
        for (int i = 0; i <= lastIndex; i++) {
            char[] c = Arrays.copyOfRange(sChars, i, i + p.length());
            Arrays.sort(c);
            if (String.valueOf(c).equals(tmpP)) {
                list.add(i);
            }
        }
        return list;
    }
}
