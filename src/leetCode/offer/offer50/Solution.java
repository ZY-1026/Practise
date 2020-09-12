package leetCode.offer.offer50;


import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0 || s == "") return ' ';
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey().charValue();
        }
        return ' ';
    }
}
