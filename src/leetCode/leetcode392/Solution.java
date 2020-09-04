package leetCode.letcode392;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public boolean isSubsequence(String s, String t) {
//        for(int i = 0 ; i< s.length(); i++){
//            if(binarySearch(t, s.charAt(i)) == false){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static String sort(String t){
//        char[] s = t.toCharArray();
//        Arrays.sort(s);
//        return new String(s);
//    }
//
//
//    // 利用二分查找在字符串t中查找字符c
//    public static boolean binarySearch(String t, char c){
//        String tmp = sort(t);
//        int mid;
//        int low = 0;
//        int high = t.length() - 1 ;
//        while(low < high){
//            mid = ( low + high) / 2;
//            if(tmp.charAt(mid) == c){
//                return true;
//            }
//            if (tmp.charAt(mid) < c){
//                low = mid +1 ;
//            }
//            else{
//                high = mid - 1;
//            }
//        }
//        return false;

        char[] arr = s.toCharArray();
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            j = t.indexOf(arr[i], j + 1);
            if (j == -1) {
                return false;
            }
        }
        return true;
    }
}
