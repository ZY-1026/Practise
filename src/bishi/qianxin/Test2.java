package bishi.qianxin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");  // 一个或者多个tab/空格
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("undo")) {
                if (res.size() > 0) {
                    String resDel = res.remove(res.size() - 1);
                    tmp.add(resDel);
                }
            } else if (strs[i].equals("redo")) {
                if (tmp.size() > 0) {
                    String tmpDel = tmp.remove(tmp.size() - 1);
                    res.add(tmpDel);
                }
            } else res.add(strs[i]);
        } // for
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) System.out.println(res.get(i));
            else System.out.print(res.get(i) + " ");
        }
    }
}
