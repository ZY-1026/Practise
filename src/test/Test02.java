package test;

import java.util.Arrays;

// 最长公共前缀
public class Test02 {
    public String helper(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.sort(strs);
        int first = strs[0].length();
        int last = strs[strs.length - 1].length();
        int length = first > last ? last : first;
        for (int i = 0; i < length; i++) {
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                stringBuilder.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
