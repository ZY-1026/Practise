package leetCode.letcode459;


public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int index = (s + s).indexOf(s, 1); //从位置1开始查找
        if (index == -1 || index == s.length()) return false;  //没找到， 或找到位置包含最后一个字符
        return true;
    }
}
