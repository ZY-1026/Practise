package leetCode.mytest.permut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DigitalPermut {
    /**
     * @param n：数组中含有n个元素
     * @param output：每次的输出结果
     * @param res：保存所有的结果
     * @param index：当前处理的下标
     */
    private void helper(int n, ArrayList<Integer> output, List<List<Integer>> res, int index) {
        if (index == n) res.add(new ArrayList<>(output));
        for (int i = index; i < n; i++) {
            Collections.swap(output, index, i);
            helper(n, output, res, index + 1);
            Collections.swap(output, index, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        helper(nums.length, output, list, 0);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new DigitalPermut().permute(nums);
        //for ()
    }
}
