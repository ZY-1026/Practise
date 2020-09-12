package leetCode.offer.offer38;

import java.util.*;

public class Solution {
    public List<String> res = new LinkedList<>();
    public char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        helper(0);
        return res.toArray(new String[res.size()]);
    }

    public void helper(int first) {
        if (first == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = first; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i, first);
            helper(first + 1);
            swap(i, first);
        }
    }

    public void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
