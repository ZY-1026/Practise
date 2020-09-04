package leetCode.letcode387;

import java.util.HashMap;

public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
