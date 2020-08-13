package kedaxunfei;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(0);
        list2.add(n - 1);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(0);
        stack2.push(n - 1);
        while (true) {
            boolean f = false;
            while (!stack1.isEmpty()) {
                int a = stack1.pop();
                int b = stack2.pop();
                if (a >= b) continue;
                f = true;
                int res = partition(A, a, b);
                stack1.push(res + 1);
                stack2.push(b);
                stack1.push(a);
                stack2.push(res - 1);
                break;
            }
            if (!f) break;
            System.out.print(A[0]);
            for (int i = 1; i < n; i++) {
                System.out.print(" " + A[i]);
            }
            System.out.println();
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int v = nums[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while (++i <= high && nums[i] < v) ;
            while (--j >= low && nums[j] > v) ;
            if (i >= j) break;
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        nums[low] = nums[j];
        nums[j] = v;
        return j;
    }
}