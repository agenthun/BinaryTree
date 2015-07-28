package com.agenthun;

/**
 * Created by Agent Henry on 2015/7/28.
 */
public class FindPostOrder extends BinaryTree {
    public void initTree(int[] preOrder, int[] inOrder) {
        this.root = this.initTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public Node initTree(int[] preOrder, int start1, int end1, int[] inOrder, int start2, int end2) {
        if (start1 > end1 || start2 > end2)
            return null;
        int rootData = preOrder[start1];
        Node head = new Node(rootData);
        //找根结点
        int rootIndex = findIndexInArray(inOrder, rootData, start2, end2);
        int offSet = rootIndex - start2 - 1;
        //左子树
        Node left = initTree(preOrder, start1 + 1, start1 + 1 + offSet, inOrder, start2, start2 + offSet);
        //右子树
        Node right = initTree(preOrder, start1 + offSet + 2, end1, inOrder, rootIndex + 1, end2);

        head.left = left;
        head.right = right;
        return head;
    }

    public int findIndexInArray(int[] a, int x, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPostOrder binaryTree = new FindPostOrder();
        int[] preOrder = {1, 2, 4, 8, 9, 5, 10, 3, 6, 7};
        int[] inOrder = {8, 4, 9, 2, 10, 5, 1, 6, 3, 7};
        binaryTree.initTree(preOrder, inOrder);
        System.out.print("后序遍历 : ");
        binaryTree.postOrder();
    }
}
