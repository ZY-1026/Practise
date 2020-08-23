package bishi.meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Test3 {
    private static void dfs(ArrayList<LinkedList<Integer>> nums, boolean visted[], int cur, LinkedList<Integer> tmp) {
        for (int next : nums.get(cur)) {
            if (visted[next]) continue;
            visted[next] = true;
            tmp.add(next);
            dfs(nums, visted, next, tmp);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        ArrayList<LinkedList<Integer>> nums = new ArrayList<>(N + 1);
        for (int index = 0; index <= N; index++) {
            nums.add(new LinkedList<>());
        }
        while (M-- != 0) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            nums.get(a).add(b);
            nums.get(b).add(a);
        }

        boolean visted[] = new boolean[N + 1];
        ArrayList<LinkedList<Integer>> res = new ArrayList<>();
        for (int index = 1; index <= N; index++) {
            if (visted[index] || nums.get(index).size() == 0) continue;
            visted[index] = true;
            LinkedList<Integer> tmp = new LinkedList<>();
            tmp.add(index);
            dfs(nums, visted, index, tmp);
            Collections.sort(tmp);
            res.add(tmp);
        }

        System.out.println(res.size());
        for (LinkedList<Integer> tmp : res) {
            for (int cur : tmp) {
                System.out.print(cur + " ");
            }
            System.out.print('\n');
        }
        sc.close();
    }
}

