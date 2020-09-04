package leetCode.letcode290;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if (s.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) { //1. 没有映射时执行
                if (map.containsValue(s[i])) return false; //2. 没有映射的情况下s[i]已被使用，则不匹配返回false
                map.put(pattern.charAt(i), s[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(s[i])) return false;
            }
        }
        return true;
    }
}
