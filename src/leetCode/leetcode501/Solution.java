package leetCode.leetcode501;


import leetCode.utils.TreeNode;

import java.util.*;

public class Solution {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        List<Integer> res = inOrder(root);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : res) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        int MAX_VALUE = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > MAX_VALUE) {
                MAX_VALUE = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == MAX_VALUE) {
                list.add(entry.getKey());
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (int num : list) {
            result[i++] = num;
        }
        return result;
    }


    private List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
