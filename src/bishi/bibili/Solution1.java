package bishi.bibili;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] strings = line.split(" ");
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
            boolean flag = Game24Points(arr);
            System.out.println(flag);
        }
    }

    /**
     * @param arr int整型一维数组
     * @return bool布尔型
     */
    public static boolean Game24Points(int[] arr) {
        // write code here
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
            list.remove(i);
            if (getResult(list, tmp)) return true;
            list.add(i, tmp);
        }
        return false;
    }

    public static boolean getResult(List<Integer> list, int tmp) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                int n = list.get(i);
                list.remove(i);
                if (getResult(list, tmp * n) || getResult(list, tmp + n) || getResult(list, tmp - n)) {
                    return true;
                } else if (tmp % n == 0) {
                    if (getResult(list, tmp / n)) {
                        return true;
                    }
                }
                list.add(i, n);
            }
            return false;
        } else {
            if (tmp == 24) return true;
            else return false;
        }
    }
}