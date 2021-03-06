package bishi.zuiyou;

import java.util.*;

public class Main2 {
    private static void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, path, res);
            used[i] = false;
            path.removeLast();
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        int[] nums = new int[string.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(string.charAt(i)).intValue() - '0';
        }
        List<List<Integer>> res = permuteUnique(nums);
        for (int i = 0; i < res.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            List<Integer> tmp = res.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                stringBuilder.append(tmp.get(j));
            }
            if (i == res.size()) {
                System.out.print(stringBuilder.toString());
            } else {
                System.out.print(stringBuilder.toString() + " ");
            }
        }
        sc.close();
    }
}
