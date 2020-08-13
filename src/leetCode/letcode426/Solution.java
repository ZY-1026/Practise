package leetCode.letcode426;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class Solution {
    public Node treeToDoublyList(Node root) {
        if (root==null) return new Node();
        return null;
    }
}