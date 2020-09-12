package leetCode.offer.offer05;

import java.util.Vector;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
        public static String replaceSpace(String s) {
        Vector vector = new Vector();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                vector.add(s.charAt(i));
            }else{
                vector.add('%');
                vector.add('2');
                vector.add('0');
            }
        } // for
        char[] chars = new char[vector.size()];
        for(int i=0 ;i <vector.size();i++){
            chars[i] = (char)vector.get(i);
        }
        return String.valueOf(chars);
    }
}
