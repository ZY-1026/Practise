package leetCode.leetcode637;

import leetCode.utils.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> listTmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                listTmp.add(tmp.val);
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            list.add(new ArrayList(listTmp));
            listTmp.clear();
        }
        Collections.reverse(list);
        return list;
    }

    private double computeAverage(List<Integer> list) {
        double res;
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = Long.valueOf(list.get(i)).longValue() + sum;
        }
        res = (double) sum / list.size();
        return res;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        List<List<Integer>> list = levelOrderBottom(root);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> tmp = list.get(i);
            res.add(computeAverage(tmp));
        }
        Collections.reverse(res);
        return res;
    }
}
