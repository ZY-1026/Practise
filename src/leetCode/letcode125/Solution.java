package leetCode.letcode125;

/***
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public  boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        if(s.trim().length()==0){
            return true;
        }
        String tmp = s.replaceAll("[^0-9|a-z|A-Z]", "");
        System.out.println(tmp);
        int length = tmp.length();
        String pre;
        String back;
        // 字符串长度为奇数
        if (length % 2 != 0) {
            pre = tmp.substring(0, length / 2);
            back = reverse(tmp.substring(length / 2 + 1));
            if (pre.equalsIgnoreCase(back)) {
                return true;
            }
        } else {
            pre = tmp.substring(0, length / 2);
            back = reverse(tmp.substring(length / 2));
            if (pre.equalsIgnoreCase(back)) {
                return true;
            }
        }
        return false;

    }

    public static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

}
