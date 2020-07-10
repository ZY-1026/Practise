package job.zhaoyin.test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Character> solution(String s, int x) {
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i) + 1));
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == x && isDigitalCharacter(entry.getKey()) == true) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    private boolean isDigitalCharacter(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
