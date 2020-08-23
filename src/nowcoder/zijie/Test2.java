package nowcoder.zijie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 水仙花数
 * <p>
 * https://www.nowcoder.com/practice/11c9f023a9f84418a15b48792a5f7c70?tpId=137&rp=1&ru=%2Fta%2Fexam-bytedance&qru=%2Fta%2Fexam-bytedance%2Fquestion-ranking
 */

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int m = Integer.valueOf(line[0]);
            int n = Integer.valueOf(line[1]);
            List<Integer> list = new ArrayList<>();
            for (int i = m; i <= n; i++) {
                if (isNums(i)) list.add(i);
            }
            if (list.size() == 0) {
                System.out.println("no");
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) System.out.println(list.get(i));
                    else System.out.print(list.get(i) + " ");
                }
            }
        }
    }

    public static boolean isNums(int num) {
        List<Integer> list = new ArrayList<>();
        int tmp = num;
        while (tmp != 0) {
            list.add(tmp % 10);
            tmp = tmp / 10;
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            result += n * n * n;
        }
        return result == num;
    }
}
