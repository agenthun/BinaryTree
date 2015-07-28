package com.agenthun;

/**
 * Created by Agent Henry on 2015/7/28.
 */
public class FindMaxDistance {
    private int maxLen = 0;

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public void findMaxDistance(Node root) {
        if (root == null) return;
        if (root.left == null) root.leftMaxDistance = 0;
        else findMaxDistance(root.left);
        if (root.right == null) root.rightMaxDistance = 0;
        else findMaxDistance(root.right);

        if (root.left != null)
            root.leftMaxDistance = max(root.left.leftMaxDistance, root.left.rightMaxDistance) + 1;
        if (root.right != null)
            root.rightMaxDistance = max(root.right.leftMaxDistance, root.right.rightMaxDistance) + 1;
        if (root.leftMaxDistance + root.rightMaxDistance > maxLen)
            maxLen = root.leftMaxDistance + root.rightMaxDistance;
    }

    class Node {
        public int data;
        public Node left;
        public Node right;
        public int leftMaxDistance;
        public int rightMaxDistance;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
