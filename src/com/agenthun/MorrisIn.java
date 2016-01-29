package com.agenthun;

public class MorrisIn {
    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }

        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            System.out.print(cur1.val + " ");
            cur1 = cur1.right;
        }
        System.out.println();
    }

    class Node {
        int val;
        Node left = null;
        Node right = null;

        public Node(int val) {
            this.val = val;
        }
    }
}