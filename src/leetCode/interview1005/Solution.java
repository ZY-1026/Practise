package leetCode.interview1005;

/**
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 示例1:
 * <p>
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public int findString(String[] words, String s) {
        if (words.length == 1 && words[0].equals(s)) return 0;
        int i = 0, j = words.length - 1;
        while (i <= j) {
            while (i < j && words[i].equals("")) i++;
            while (i < j && words[j].equals("")) j--;
            if (i <= j) {
                int mid = (i + j) / 2;
                while (mid < j && words[mid].equals("")) mid++;
                if (words[mid].compareTo(s) > 0) {
                    j = mid - 1;
                } else if (words[mid].compareTo(s) < 0) {
                    i = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}

