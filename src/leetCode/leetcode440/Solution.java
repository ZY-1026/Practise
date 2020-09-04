package leetCode.letcode440;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int findKthNumber(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i + 1);
        Collections.sort(list, (o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            if (s1.length() == s2.length()) return (int) (o1 - o2);
            else {
                for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        return s1.charAt(i) - s2.charAt(i);
                    }
                }
            }
            return s1.length() - s2.length();
        });
        return list.get(k - 1);
    }

}
