package leetCode.letcode257;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import leetCode.utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root){
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        String cur = "";
        cal(root, cur, result);
        return result;
    }

    private static void cal(TreeNode node, String cur, List<String> result){
        if (node != null){
            cur += node.val;
            if (node.right == null && node.left == null){
                result.add(cur);
            }else{
                cur += "->";
                cal(node.left, cur, result);
                cal(node.right, cur, result);
            }
        }
    }
}
