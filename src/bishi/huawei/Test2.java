package bishi.huawei;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        for (int index = 0; index < 5; index++) {
            nums[index] = sc.nextInt();
        }
        int[] price = {13, 11, 7, 3, 1};
        int target = sc.nextInt();
        Queue<Integer> bfs = new LinkedList<>();
        Queue<Integer> bfsn = new LinkedList<>();

        bfs.offer(0);
        bfsn.offer(0);

        boolean[] flag = new boolean[target];
        while (!bfs.isEmpty()) {
            int sum = bfs.poll();
            int depth = bfsn.poll();
            for (int index = 0; index < 5; index++) {
                int nextsum = sum + price[index];
                if (nextsum == target) {
                    System.out.println(depth + 1);
                    sc.close();
                    return;
                } else if (nextsum < target && !flag[nextsum]) {
                    flag[nextsum] = true;
                    bfs.offer(nextsum);
                    bfsn.offer(depth + 1);
                }
            }
        }
        sc.close();
    }
}

