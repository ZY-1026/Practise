package leetCode.mytest.permut;

import java.util.ArrayList;
import java.util.List;

public class charPermut {
    public void helper(int first, char[] c, List<String> res) {
        int n = c.length;
        if (first == n) {
            res.add(String.valueOf(c));
            return;
        }
        for (int i = first; i < n; i++) {
            swap(c, i, first);
            helper(first + 1, c, res);
            swap(c, i, first);
        }
    }

    public void swap(char[] c, int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public String[] permutation(String s) {
        char[] c = s.toCharArray();
        List<String> res = new ArrayList<>();
        helper(0, c, res);
        int n = res.size();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = res.get(i);
        }
        return strings;
    }


    public static void main(String[] args) {
        String s = "acb";
        String[] res = new charPermut().permutation(s);
        for (String str : res)
            System.out.println(str);
    }
}
