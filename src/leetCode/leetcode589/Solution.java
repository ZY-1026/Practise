package leetCode.letcode589;

import leetCode.utils.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        dfs(root, list);
        return list;
    }

    private void dfs(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node node : root.children) {
            dfs(node, res);
        }
    }
}
