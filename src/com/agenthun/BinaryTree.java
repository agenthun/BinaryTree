package com.agenthun;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Agent Henry on 2015/7/28.
 */
public class BinaryTree {
    public Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void buildTree(int[] data) {
        for (int i = 0; i < data.length; i++) {
            insert(data[i]);
        }
    }

    //中序遍历
    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    //先序遍历
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    //后序遍历
    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
        }
    }

    public void postOrder() {
        this.postOrder(this.root);
    }

    //层序遍历
    public void layerTranverse() {
        if (this.root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(this.root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.data + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] data = {2, 8, 7, 4, 9, 3, 1, 6, 7, 5};
        binaryTree.buildTree(data);

        System.out.print("中序遍历 : ");
        binaryTree.inOrder();
        System.out.println();

        System.out.print("先序遍历 : ");
        binaryTree.preOrder();
        System.out.println();

        System.out.print("后序遍历 : ");
        binaryTree.postOrder();
        System.out.println();
    }
}

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
